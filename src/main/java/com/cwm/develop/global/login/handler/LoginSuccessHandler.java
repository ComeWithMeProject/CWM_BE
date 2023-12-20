package com.cwm.develop.global.login.handler;

import com.cwm.develop.global.jwt.service.JwtService;
import com.cwm.develop.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RequiredArgsConstructor
public class LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    /* 커스텀 JSON 로그인 필터를 정상적으로 통과하여 인증 처리가 되었을 때(=로그인 성공)
     * 로그인 성공 핸들러가 동작한다.
     * SimpleUrlAuthenticationSuccessHandler를 상속받아 구현했다.
     */

    private final JwtService jwtService;
    private final UserRepository userRepository;

    @Value("${jwt.access.expiration}")
    private String accessTokenExpiration;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) {
        String email = extractUsername(authentication); //인증 정보에서 Username(email) 추출
        String accessToken = jwtService.createAccessToken(email); //JwtService의 createAccessToken을 사용하여 AccessToken 발급
        String refreshToken = jwtService.createRefreshToken(); //JwtService의 createRefreshToken을 사하여 RefreshToken 발급

        jwtService.sendAccessAndRefreshToken(response, accessToken, refreshToken); //응답 헤더에 accessToken, refreshToken 실어서 응답

        userRepository.findByEmail(email)
                .ifPresent(user -> {
                    user.updateRefreshToken(refreshToken);
                    userRepository.saveAndFlush(user);
                });
        log.info("로그인에 성공했습니다. 이메일 : {}", email);
        log.info("로그인에 성공했습니다. AccessToken : {}", accessToken);
        log.info("발급된 AccessToken 만료 기간 : {}", accessTokenExpiration);
    }

    private String extractUsername(Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return userDetails.getUsername();
    }
}
