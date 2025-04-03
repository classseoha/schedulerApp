package com.example.schedulerapp.repository;

import com.example.schedulerapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    //특정 사용자의 username을 기준으로 User 엔티티를 조회 (해당 username이 존재하면 Optional<Member>을 반환, 없으면 Optional.empty() 반환)
    Optional<User> findUserByUsername(String username);

    //원래 인터페이스에서는 메서드 구현이 불가능하지만 default 기능 사용하면 가능 (커스텀 조회 기능 구현)
    //username이 존재하면 Member 엔티티 반환, 존재하지 않으면 예외(ResponseStatusException) 발생
    default User findUserByUsernameOrElseThrow(String username) {

        return findUserByUsername(username).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist username = " + username));
    }

    //id가 존재하면 Member 엔티티 반환, id가 존재하지 않으면 ResponseStatusException을 발생시켜 404 NOT FOUND 처리
    default User findByIdOrElseThrow(Long id) {

        return findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id));
    }
}
