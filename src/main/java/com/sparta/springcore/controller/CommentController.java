package com.sparta.springcore.controller;

import com.sparta.springcore.model.Comment;
import com.sparta.springcore.dto.CommentRequestDto;
import com.sparta.springcore.repository.CommentRepository;
import com.sparta.springcore.security.UserDetailsImpl;
import com.sparta.springcore.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CommentController {

    private final CommentService commentService;
    private final CommentRepository commentRepository;

    //댓글 목록 조회
    @GetMapping("/api/comment/{id}")
    public List<Comment> readComment(@PathVariable String id){
        return commentService.get_Comment(Long.parseLong(id));
    }

    //댓글 작성
    @PostMapping("/api/comment/{id}")
    public String writeComment(@PathVariable Long id, @RequestBody CommentRequestDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails){
        Long memoId = id;
        try{
            commentService.create_Comment(memoId, requestDto, userDetails);
            return "Success";
        }catch(IllegalArgumentException e){
            return e.getMessage();
        }
    }

    //댓글 수정
    @PutMapping("/api/comment/{id}")
    public String updateComment(@PathVariable Long id, @RequestBody CommentRequestDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails){
        Long commentId = id;
        try{
            commentService.update_Comment(commentId, requestDto, userDetails);
            return "Success";
        }catch(IllegalArgumentException e){
            return e.getMessage();
        }
    }

    //댓글 삭제
    @DeleteMapping("/api/comment/{id}")
    public String deleteMemo(@PathVariable Long id, @AuthenticationPrincipal UserDetailsImpl userDetails){
        Long commentId = id;
        try{
            commentService.delete_Comment(commentId, userDetails);
            return "Success";
        }catch(IllegalArgumentException e){
            return e.getMessage();
        }
    }
}
