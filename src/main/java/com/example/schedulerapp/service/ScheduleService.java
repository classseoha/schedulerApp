package com.example.schedulerapp.service;

import com.example.schedulerapp.dto.ScheduleResponseDto;
import com.example.schedulerapp.dto.ScheduleUpdateRequestDto;
import com.example.schedulerapp.entity.Schedule;
import com.example.schedulerapp.entity.User;
import com.example.schedulerapp.repository.ScheduleRepository;
import com.example.schedulerapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;

    public ScheduleResponseDto save(String title, String contents, String username) {

        User findUser = userRepository.findUserByUsernameOrElseThrow(username);

        Schedule schedule = new Schedule(title, contents);
        schedule.setUser(findUser); //username을 기준으로 DB에서 User 엔티티를 조회 (해당 username을 가진 User 엔티티 객체가 저장됨)

        Schedule savedSchedule = scheduleRepository.save(schedule); //DB에 일정 저장

        return new ScheduleResponseDto(savedSchedule.getId(), savedSchedule.getTitle(), savedSchedule.getContents()); //ScheduleResponseDto를 만들어서 반환
    }

    public List<ScheduleResponseDto> findAll() {

        //BoardResponseDto List 형태로 반환 받을 수 있게 해줌
        return scheduleRepository.findAll()
                .stream()
                .map(ScheduleResponseDto::toDto) //이렇게 하면 스태틱 메서드로 만들어짐
                .toList();
    }

    public ScheduleResponseDto findById(Long id) {

        Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(id);
        User writer = findSchedule.getUser();//작성자 찾기

        return new ScheduleResponseDto(id, findSchedule.getTitle(), findSchedule.getContents());
    }

    public void delete(Long id) {

        Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(id);

        scheduleRepository.delete(findSchedule);
    }

    public ScheduleResponseDto update(Long id, ScheduleUpdateRequestDto requestDto) {

        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다."));

        if (requestDto.getTitle() != null && !requestDto.getTitle().isBlank()) {
            schedule.setTitle(requestDto.getTitle());
        }

        if (requestDto.getContents() != null && !requestDto.getContents().isBlank()) {
            schedule.setContents(requestDto.getContents());
        }

        Schedule updatedSchedule = scheduleRepository.save(schedule);

        return new ScheduleResponseDto(updatedSchedule.getId(), updatedSchedule.getTitle(), updatedSchedule.getContents());

    }
}
