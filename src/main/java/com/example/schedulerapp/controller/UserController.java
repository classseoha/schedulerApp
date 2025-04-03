package com.example.schedulerapp.controller;

import com.example.schedulerapp.dto.UserRequestDto;
import com.example.schedulerapp.dto.UserResponseDto;
import com.example.schedulerapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //@Controller + @ResponseBody (반환 데이터 자동으로 JSON 형식 변환)
@RequestMapping("/users")
@RequiredArgsConstructor //생성자 자동 주입
public class UserController {

    private final UserService userService;

    //회원가입 기능
    @PostMapping("/signup")
    public ResponseEntity<UserResponseDto> signUp(@RequestBody UserRequestDto requestDto) {

        UserResponseDto userResponseDto = userService.signUp(requestDto.getUsername(), requestDto.getPassword(), requestDto.getEmail());

        return new ResponseEntity<>(userResponseDto, HttpStatus.CREATED);
    }

}
