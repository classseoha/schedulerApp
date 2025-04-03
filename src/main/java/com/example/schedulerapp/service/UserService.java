package com.example.schedulerapp.service;

import com.example.schedulerapp.dto.UserResponseDto;
import com.example.schedulerapp.entity.User;
import com.example.schedulerapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService { //확장될 여지가 없다면 구현체 클래스 그대로 사용해도 됨, 조금이라도 변경 또는 확장될 여지가 있다면 무조건 인터페이스로 설계

    private final UserRepository userRepository;

    public UserResponseDto signUp(String username, String password, String email) {

        User user = new User(username, password, email);

        User savedUser = userRepository.save(user); //JPA가 제공하는 기본 메서드

        return new UserResponseDto(savedUser.getId(), savedUser.getUsername(), savedUser.getEmail());
    }
}
