package com.example.schedulerapp.dto;

import com.example.schedulerapp.entity.Schedule;
import lombok.Getter;

@Getter
public class ScheduleResponseDto {

    private final Long id;

    private final String title;

    private final String contents;

    public ScheduleResponseDto(Long id, String title, String contents) {
        this.id = id;
        this.title = title;
        this.contents = contents;
    }

    public static ScheduleResponseDto toDto(Schedule schedule) { //Schedule 엔티티를 ScheduleResponseDto로 변환하는 역할 (DB에서 조회한 엔티티를 그대로 반환하지 않고 DTO로 변환하여 응답)

        return new ScheduleResponseDto(schedule.getId(), schedule.getTitle(), schedule.getContents());
    }
}
