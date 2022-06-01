package com.sparta.springcore.service;

import com.sparta.springcore.dto.MemoRequestDto;
import com.sparta.springcore.model.Memo;
import com.sparta.springcore.repository.MemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;



@RequiredArgsConstructor
@Service
public class MemoService {

    private final MemoRepository memoRepository;



    public void update(Long id, MemoRequestDto requestDto) {
        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        memo.update(requestDto);
    }

    public void delete(Long id, MemoRequestDto requestDto) {
        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        memo.delete(requestDto);
    }
}
