package com.example.cwm.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User  extends BaseTimeEntity {

    //id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    //이메일
    @Column(name = "user_email", length = 100, nullable = false)
    private String email;

    //이름
    @Column(name = "user_name", length = 100, nullable = false)
    private String name;

    //비밀번호
    @Column(name = "password", length = 255, nullable = false)
    private String password;

    //역할 - user, admin, guest...
    @Column(name = "user_type", length = 10)
    @Enumerated(EnumType.STRING)
    private Role userType;

    //삭제여부
    @Column(name = "delYN", length = 1)
    private String delYN;

    //잠금여부
    @Column(name = "lock_yn", length = 1)
    private String lockYN;

    //잠금횟수
    @Column(name = "lock_cnt", columnDefinition = "integer default 0")
    private Integer lockCnt;

    //잠금최종시점
    @Column(name = "lock_last_date")
    private LocalDateTime lockLastDate;

    //소셜타입 - naver, kakao, google...
    @Column(name = "social_type", length = 100)
    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    //소셜아이디 - 로그인한 티입의 식별자 값 (ouath 로그인 유저의 식별을 위한 값)
    @Column(name = "social_id", length = 200)
    private String socialId;

    //리프래시 토큰
    @Column(name = "refresh_token", length = 1000)
    private String refreshToken;

    //회원가입 시 유저 Role 설정 - 유저 권한 설정
    public void getUserRole() {
        this.userType = Role.USER;
    }

    //비밀번호 암호화
    public void passwordEncode(PasswordEncoder passwordEncoder) {
        this.password = passwordEncoder.encode(this.password);
    }

    //RefreshToken 재발급
    public void updateRefreshToken(String updateRefreshToken) {
        this.refreshToken = updateRefreshToken;
    }
}
