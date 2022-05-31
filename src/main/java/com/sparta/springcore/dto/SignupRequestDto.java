package com.sparta.springcore.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor

public class SignupRequestDto {
    private String username;
    private String password;
    private String passwordCk;
    private String email;
    private boolean admin = false;
    private String adminToken = "";
}