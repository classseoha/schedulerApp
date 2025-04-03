package com.example.schedulerapp.dto;

import lombok.Getter;

@Getter
public class UpdatePasswordRequestDto {

    //기존패스워드와 새패스워드 저장해서 저장된 패스워드와 기존패스워드가 일치한다면 새패스워드로 변경해줄 예정
    private final String oldPassword;

    private final String newPassword;

    public UpdatePasswordRequestDto(String oldPassword, String newPassword) {
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
    }
}
