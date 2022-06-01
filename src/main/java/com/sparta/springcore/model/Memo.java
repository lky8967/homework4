package com.sparta.springcore.model;

import com.sparta.springcore.dto.MemoRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor//기본생성자
public class Memo extends Timestamped {

    // ID가 자동으로 생성 및 증가합니다.
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long memoId;



    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;


    private String commnets;


    public Memo(String title, String content){
        this.title = title;
        this.content = content;
    }

    public Memo(MemoRequestDto requestDto){
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
    }


    public void update(MemoRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
    }

    public void delete(MemoRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
    }
}
