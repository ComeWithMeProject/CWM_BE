package com.cwm.develop.user.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserSignUpDto {

    //자체 로그인 회원 가입 API에 RequestBody로 사용할 UserSignUpDto 생성
    //OAuth2 로그인만 구현할 것이기에 해당 Dto는 사용하지 않을 예정??
    private String email;
    private String name;
    private String password;
    private Integer heart;
    private String imageUrl;

}
