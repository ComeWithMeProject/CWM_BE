package com.cwm.develop.user.service;

import com.cwm.develop.global.jwt.service.JwtService;
import com.cwm.develop.user.Role;
import com.cwm.develop.user.User;
import com.cwm.develop.user.dto.UserRequestDto;
import com.cwm.develop.user.dto.UserResponseDto;
import com.cwm.develop.user.dto.UserSuccessResponseDto;
import com.cwm.develop.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    //자체 로그인 회원 가입 시 사용하는 회원 가입 API 로직

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RedisTemplate<String, String> redisTemplate;
    private final JwtService jwtService;

    @Transactional
    public List<User> allSearch() {
        return userRepository.findAll();
    }

    //유저 회원가입
    @Transactional
    public UserResponseDto signUpUser(UserRequestDto userRequestDto) throws Exception{
        if(userRepository.findByEmail(userRequestDto.getEmail()).isPresent()) {
            throw new Exception("이미 존재하는 회원입니다.");
        }

        if (userRepository.findByName(userRequestDto.getName()).isPresent()) {
            throw new Exception("이미 존재하는 닉네임입니다.");
        }

        User user1 = User.builder()
                .email(userRequestDto.getEmail())
                .name(userRequestDto.getName())
                .password(passwordEncoder.encode(userRequestDto.getPassword()))
                .heart(userRequestDto.getHeart())
                .imageUrl(userRequestDto.getImageUrl())
                .role(Role.USER)
                .build();
        userRepository.save(user1);
        return new UserResponseDto(user1);
    }

    //유저 정보 조회
//    @Transactional
//    public UserResponseDto selectUser() {
//
//
//        return new UserResponseDto(user);
//    }

    //유저 회원정보 수정
    @Transactional
    public UserResponseDto updateUser(Long userId, UserRequestDto userRequestDto) throws Exception {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다."));
        if(!userRequestDto.getPassword().equals(user.getPassword()))
            throw new Exception("비밀번호가 일치하지 않습니다.");

        user.update(userRequestDto);
        return new UserResponseDto(user);
    }

    //유저 회원 탈퇴
    @Transactional
    public UserSuccessResponseDto deleteUser(Long userId, UserRequestDto userRequestDto) throws Exception {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다."));

        if(!userRequestDto.getPassword().equals(user.getPassword()))
            throw new Exception("비밀번호가 일치하지 않습니다.");

        userRepository.deleteById(userId);
        return new UserSuccessResponseDto(true);
    }

    @Transactional
    public void logout(Authentication authentication) {
        String email = authentication.getName();
        System.out.println("이메일: " + email);

        if (redisTemplate.hasKey(email)) {
            redisTemplate.delete(email); // 해당 키가 존재하면 삭제
            System.out.println("토큰 삭제됨");
        } else {
            System.out.println("토큰이 존재하지 않음");
        }
        // 여기에 사용자 정보 확인하는 코드가 있었을 텐데 삭제하세요.
    }
}
