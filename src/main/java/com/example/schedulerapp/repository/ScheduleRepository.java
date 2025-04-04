package com.example.schedulerapp.repository;

import com.example.schedulerapp.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    //Spring Data JPA의 findById()를 활용하여 특정 ID의 Board 엔티티를 조회하는 기능
    default Schedule findByIdOrElseThrow(Long id) {

        return findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id));
    }

}
