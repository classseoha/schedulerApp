package com.example.schedulerapp.service;

import com.example.schedulerapp.dto.SignUpResponseDto;
import com.example.schedulerapp.dto.UserResponseDto;
import com.example.schedulerapp.entity.User;
import com.example.schedulerapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService { //확장될 여지가 없다면 구현체 클래스 그대로 사용해도 됨, 조금이라도 변경 또는 확장될 여지가 있다면 무조건 인터페이스로 설계

    private final UserRepository userRepository;

    public SignUpResponseDto signUp(String username, String password, String email) {

        User user = new User(username, password, email);

        User savedUser = userRepository.save(user); //JPA가 제공하는 기본 메서드

        return new SignUpResponseDto(savedUser.getId(), savedUser.getUsername(), savedUser.getEmail());
    }

    public UserResponseDto findById(Long id) {

        //Null을 안전하게 다루기위해 optional로 지정됨
        Optional<User> optionalMember = userRepository.findById(id); //아직 구현하지 않았지만 simpleJpaReporitory에서 구현이 되어있는 것

        if (optionalMember.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exists id : " + id);
        }

        User findMember = optionalMember.get();

        return new UserResponseDto(findMember.getUsername(), findMember.getEmail());
    }

    @Transactional //하나의 트랜젝션 안에서 동작하도록 해줘야 함
    public void updatePassword(Long id, String oldPassword, String newPassword) {

        User findMember = userRepository.findByIdOrElseThrow(id); //이렇게 하지 않으면 optionalMember가 비어있는지 확인하는 작업을 매번 반복해야됨

        //비밀번호 일치하는지 검사
        if (!findMember.getPassword().equals(oldPassword)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,  "비밀번호가 일치하지 않습니다.");
        }

        findMember.updatePassword(newPassword);
    }

    @Transactional
    public void deleteUser(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 존재하지 않습니다."));

        userRepository.delete(user); // 유저 삭제
    }

}
