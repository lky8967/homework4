package com.sparta.springcore.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor

public class MemoRequestDto {

    private String username;
    private String title;
    private String contents;

}
