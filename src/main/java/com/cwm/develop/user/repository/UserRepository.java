package com.cwm.develop.user.repository;

import com.cwm.develop.user.SocialType;
import com.cwm.develop.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    //OAuth2 로그인만 구현할 것이기에 해당 메소드는 사용하지 않을 예정??
    Optional<User> findByEmail(String email);
    //OAuth2 로그인만 구현할 것이기에 해당 메소드는 사용하지 않을 예정??
    Optional<User> findByName(String name);

    Optional<User> findByRefreshToken(String refreshToken);

    /*
     * OAuth2 로그인 구현 시 사용하는 메소드
     * 소셜 타입과 소셜의 식별값으로 회원 찾는 메소드
     * 정보 제공을 동의한 순간 DB에 저장해야하지만, 아직 추가 정보(좋아요 수)를 입력받지 않았으므로
     * 유저 객체는 DB에 있지만, 추가 정보가 빠진 상태이다.
     * 따라서 추가 정보를 입력받아 회원 가입을 진행할 때 소셜 타입, 식별자로 해당 회원을 찾기 위한 메소드
     */
    Optional<User> findBySocialTypeAndSocialId(SocialType socialType, String socialId);
}
