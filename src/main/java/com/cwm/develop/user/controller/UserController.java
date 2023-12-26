package com.cwm.develop.user.controller;

import com.cwm.develop.user.User;
import com.cwm.develop.user.dto.UserRequestDto;
import com.cwm.develop.user.dto.UserResponseDto;
import com.cwm.develop.user.dto.UserSignUpDto;
import com.cwm.develop.user.dto.UserSuccessResponseDto;
import com.cwm.develop.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    //유저 회원가입
    @PostMapping("/users")
    public UserResponseDto signUp(@RequestBody UserRequestDto userRequestDto) throws Exception {
        return userService.signUpUser(userRequestDto);
    }

    //유저 정보 조회(마이페이지에 보낼 정보)
//    @PostMapping("/user/{id}")
//    public UserResponseDto selectUser(@PathVariable ) {
//        return userService.selectUser(id);
//    }

    //유저 회원정보 수정
    @PutMapping("/users/{id}")
    public UserResponseDto updateUser(@PathVariable Long id, @RequestBody UserRequestDto userRequestDto) throws Exception {
        return userService.updateUser(id, userRequestDto);
    }

    //유저 회원 탈퇴
    @DeleteMapping("/users/{id}")
    public UserSuccessResponseDto deleteUser(@PathVariable Long id, @RequestBody UserRequestDto userRequestDto) throws Exception {
        return userService.deleteUser(id, userRequestDto);
    }


    @GetMapping("/jwt-test")
    public String jwtTest() {
        return "jwtTest 요청 성공";
    }
}
