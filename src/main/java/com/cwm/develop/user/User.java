package com.cwm.develop.user;

import com.cwm.develop.user.dto.UserRequestDto;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "USERS")
@Builder
public class User extends UserBaseTimeEntity{

    //회원 번호
    @Id //pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private Long userId;

    //회원 이메일
    @Column(name = "userEmail", nullable = false)
    private String email;

    //회원 이름
    @Column(name = "userName", nullable = false)
    private String name;

    //회원 비밀번호
    @Column(name = "userPassword") //nullable = false 제약조건을 걸면 db에 저장되지 않으면서 에러 발생
    private String password;

    //회원 좋아요 수
    @Column(name = "userHeart")
    private int heart;

    //회원 프로필 이미지 URL
    @Column(name = "userImageUrl")
    private String imageUrl;

    //권한 관련 ENUM - Role 필드
    //OAuth2 로그인 시 Role을 USER로 설정할 예정
    @Enumerated(EnumType.STRING)
    private Role role;

    //OAuth2 Type 관련 EUNM - SocialType 필드
    //구글, 네이버, 카카오 등의 소셜 타입이 저장되는 필드
    @Enumerated(EnumType.STRING)
    private SocialType socialType; //GOOGLE, NAVER, KAKAO

    //소셜 타입의 식별자 값 필드
    private String socialId; //로그인한 소셜 타입의 식별자 값이 저장되는 필드

    //JWT RefreshToken 필드
    //JWT를 사용하여 로그인 성공 시 AccessToken, RefreshToken을 발행하는데
    //발행된 RefreshToken을 User Entity에 저장한다.
    private String refreshToken; //리프레시 토큰

    //유저 권한 설정 메소드
    public String getUserRole() {
        this.role = Role.USER;
        return null;
    }

    //비밀번호 암호화 메소드
    public void passwordEncode(PasswordEncoder passwordEncoder) {
        this.password = passwordEncoder.encode(this.password);
    }

    //RefreshToken 재발급 메소드
    public void updateRefreshToken(String updateRefreshToken) {
        this.refreshToken = updateRefreshToken;
    }

    public User(UserRequestDto requestDto) {
        this.email = requestDto.getEmail();
        this.name = requestDto.getName();
        this.password = requestDto.getPassword();
        this.heart = requestDto.getHeart();
        this.imageUrl = requestDto.getImageUrl();
        this.role = requestDto.getRole();
        this.socialType = requestDto.getSocialType();
        this.socialId = requestDto.getSocialId();
    }

    public void update(UserRequestDto requestDto) {
        this.email = requestDto.getEmail();
        this.name = requestDto.getName();
        this.password = requestDto.getPassword();
        this.heart = requestDto.getHeart();
        this.imageUrl = requestDto.getImageUrl();
        this.role = requestDto.getRole();
        this.socialType = requestDto.getSocialType();
        this.socialId = requestDto.getSocialId();
    }
}
