package com.example.cwm.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {

    USER("ROLE_USER"), GUEST("ROLE_GUEST"), ADMIN("ROLE_ADMIN");

    private final String key;

    /*
        key 필드를 추가하여 "ROLE_"을 붙인 이유
        : 스프링 시큐리티에서는 권한(Role) 코드에 항상 "ROLE_" 접두사가 붙어야 하기 때문에 "ROLE_"을 설정
     */
}
