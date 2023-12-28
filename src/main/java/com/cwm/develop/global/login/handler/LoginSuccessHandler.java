package com.cwm.develop.global.login.handler;

import com.cwm.develop.global.jwt.service.JwtService;
import com.cwm.develop.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.web.DefaultRedirectStrategy;

@Slf4j
@RequiredArgsConstructor
public class LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final RedisTemplate<String, String> redisTemplate;

    @Value("${jwt.access.expiration}")
    private String accessTokenExpiration;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) {
        String email = extractUsername(authentication);
        String accessToken = jwtService.createAccessToken(email);
        String refreshToken = jwtService.createRefreshToken();

        if (email != null && accessToken != null) {
            redisTemplate.opsForValue().set(email, accessToken);
        } else {
            log.error("Email 또는 AccessToken 값이 null입니다. Redis에 저장하지 않습니다.");
            return;
        }

        // JWT를 클라이언트에게 전송
        response.setHeader("Authorization", "Bearer " + accessToken);

        // RefreshToken도 JWT로 생성하여 클라이언트에게 전송
        response.setHeader("Authorization-refresh", "Bearer " + refreshToken);

        userRepository.findByEmail(email)
                .ifPresent(user -> {
                    user.updateRefreshToken(refreshToken);
                    userRepository.saveAndFlush(user);
                });
        log.info("로그인에 성공했습니다. 이메일 : {}", email);
        log.info("로그인에 성공했습니다. AccessToken : {}", accessToken);
        log.info("로그인에 성공했습니다. RefreshToken : {}", refreshToken);
        log.info("발급된 AccessToken 만료 기간 : {}", accessTokenExpiration);

        // 리다이렉션을 위한 기본 대상 URL 설정
        setDefaultTargetUrl("/api/areaBasedList1/main?page=1&size=12");

        // RedirectStrategy를 사용하여 리다이렉션 수행
        try {
            new DefaultRedirectStrategy().sendRedirect(request, response, getDefaultTargetUrl());
        } catch (Exception e) {
            log.error("리다이렉션 중 오류 발생: {}", e.getMessage());
        }
    }

    private String extractUsername(Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return userDetails.getUsername();
    }
}
