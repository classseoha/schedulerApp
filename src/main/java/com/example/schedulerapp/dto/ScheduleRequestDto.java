package com.example.schedulerapp.dto;

import lombok.Getter;

@Getter
public class ScheduleRequestDto {

    private final String title;

    private final String contents;

    private final String username;

    public ScheduleRequestDto(String title, String contents, String username) {
        this.title = title;
        this.contents = contents;
        this.username = username;
    }
}
