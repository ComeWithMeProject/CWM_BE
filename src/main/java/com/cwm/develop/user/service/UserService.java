package com.cwm.develop.user.service;

import com.cwm.develop.user.Role;
import com.cwm.develop.user.User;
import com.cwm.develop.user.dto.UserSignUpDto;
import com.cwm.develop.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    //자체 로그인 회원 가입 시 사용하는 회원 가입 API 로직
    //OAuth2 로그인만 구현할 것이기에 해당 서비스는 사용하지 않을 예정??

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void signUp(UserSignUpDto userSignUpDto) throws Exception{
        if(userRepository.findByEmail(userSignUpDto.getEmail()).isPresent()) {
            throw new Exception("이미 존재하는 회원입니다.");
        }

        if (userRepository.findByName(userSignUpDto.getName()).isPresent()) {
            throw new Exception("이미 존재하는 닉네임입니다.");
        }

        User user1 = User.builder()
                .email(userSignUpDto.getEmail())
                .name(userSignUpDto.getName())
                .password(passwordEncoder.encode(userSignUpDto.getPassword()))
                .heart(userSignUpDto.getHeart())
                .imageUrl(userSignUpDto.getImageUrl())
                .role(Role.USER)
                .build();

        userRepository.save(user1);
    }
}
