package com.cwm.develop.global.login.handler;

import com.cwm.develop.global.jwt.service.JwtService;
import com.cwm.develop.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired; // 이 부분 추가
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.data.redis.core.RedisTemplate; // 이 부분 추가

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
@RequiredArgsConstructor
public class LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final RedisTemplate<String, String> redisTemplate; // 이 부분 추가

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException {
        String email = extractUsername(authentication);
        String accessToken = jwtService.createAccessToken(email);
        String refreshToken = jwtService.createRefreshToken();
    
        if (email != null && accessToken != null) {
            redisTemplate.opsForValue().set(email, accessToken);
        } else {
            log.error("Email 또는 AccessToken 값이 null입니다. Redis에 저장하지 않습니다.");
            return;
        }
    
        jwtService.sendAccessAndRefreshToken(response, accessToken, refreshToken);
    
        userRepository.findByEmail(email)
                .ifPresent(user -> {
                    user.updateRefreshToken(refreshToken);
                    userRepository.saveAndFlush(user);
                });
    
        log.info("로그인에 성공했습니다. 이메일 : {}", email);
        log.info("로그인에 성공했습니다. AccessToken : {}", accessToken);
        log.info("발급된 AccessToken 만료 기간 : {}", accessTokenExpiration);
    
        // 리다이렉트 하기 전에 토큰을 응답 헤더에 추가합니다.
        response.addHeader("Authorization", "Bearer " + accessToken);
        response.addHeader("Authorization", "Bearer " + refreshToken);
    
        String redirectUrl = "/api/areaBasedList1/main?page=1&size=12";
        response.sendRedirect(request.getContextPath() + redirectUrl);
    }
    
        private String extractUsername(Authentication authentication) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            return userDetails.getUsername();
        }
    }
