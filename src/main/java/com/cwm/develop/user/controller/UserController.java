package com.cwm.develop.user.controller;

import com.cwm.develop.translate.LocalDateTimeDeserializer;
import com.cwm.develop.translate.LocalDateTypeAdapter;
import com.cwm.develop.user.User;
import com.cwm.develop.user.dto.UserRequestDto;
import com.cwm.develop.user.dto.UserResponseDto;
import com.cwm.develop.user.dto.UserSignUpDto;
import com.cwm.develop.user.dto.UserSuccessResponseDto;
import com.cwm.develop.user.repository.UserRepository;
import com.cwm.develop.user.service.UserService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    //유저 회원가입
    @PostMapping("/users")
    public UserResponseDto signUp(@RequestBody UserRequestDto userRequestDto) throws Exception {
        return userService.signUpUser(userRequestDto);
    }

    @GetMapping("/my")
    public User findUser(Authentication authentication) {
        if (authentication == null) {
            throw new BadCredentialsException("회원 정보를 찾을 수 없습니다.");
        }
        return userRepository.findByEmail(authentication.getName()).get();
    }

    //유저 정보 조회(마이페이지에 보낼 정보)
//    @PostMapping("/user/{id}")
//    public UserResponseDto selectUser(@PathVariable ) {
//        return userService.selectUser(id);
//    }

    @GetMapping("/users/search")
    public String allSearch() {
        List<User> list = userService.allSearch();

//        GsonBuilder gsonBuilder = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, new LocalDateTimeDeserializer());
//
//        Gson gson = gsonBuilder.setPrettyPrinting().create();

//        Gson gson = new GsonBuilder()
//                .registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter())
//                .create();

        String jsonString = new Gson().toJson(list);

        System.out.println(jsonString);

        return jsonString;
    }

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


    @PostMapping(value = "/logout")
    public String logout(Authentication authentication) {
        userService.logout(authentication);
        return "로그아웃 성공!";
    }

}
