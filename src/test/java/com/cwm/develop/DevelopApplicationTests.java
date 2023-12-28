package com.cwm.develop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DevelopApplicationTests {

    @Autowired
    private UserService userService; // UserService를 주입받음

    @Test
    void contextLoads() {
        // UserService를 사용하여 회원 가입 또는 로그인과 같은 기능을 테스트하는 코드 작성
        // 예를 들어, userService의 메서드를 호출하고 반환값을 검증하는 코드를 작성할 수 있습니다.
    }

}
