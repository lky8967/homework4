package com.sparta.springcore.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sparta.springcore.dto.MemoRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor // 기본생성자를 만듭니다.
@Getter
@Setter
@Entity // 테이블과 연계됨을 스프링에게 알려줍니다.
public class Memo extends Timestamped { // 생성,수정 시간을 자동으로 만들어줍니다.
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private String title;


    @JsonManagedReference // 직렬화 허용 어노테이션
    @OneToMany(mappedBy = "memo", orphanRemoval = true) // orpahRemanal = true 부모 삭제시 자식도 삭제
    private List<Comment> comments;


    public Memo(String username, String contents, String title) {
        this.username = username;
        this.contents = contents;
        this.title = title;
    }

    public Memo(MemoRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
        this.title = requestDto.getTitle();
    }

    public void update(MemoRequestDto requestDto){
        //this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
    }

    public void delete(MemoRequestDto requestDto) {
        this.contents = requestDto.getContents();
        this.title = requestDto.getTitle();
    }
}
