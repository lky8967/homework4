package com.sparta.springcore.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class CommentRequestDto {
    public String re_content;

    //입력?
    public CommentRequestDto(String re_content){
        this.re_content = re_content;
    }
}

