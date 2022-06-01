package com.sparta.springcore.controller;

import com.sparta.springcore.dto.MemoRequestDto;
import com.sparta.springcore.model.Memo;
import com.sparta.springcore.repository.MemoRepository;
import com.sparta.springcore.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MemoController {


    private final MemoRepository memoRepository;
    private final MemoService memoService;

    @PostMapping("/api/memos")
    public Memo createMemo(@RequestBody MemoRequestDto requestDto) {
        System.out.println("111111");
        Memo memo = new Memo(requestDto);
        System.out.println("memo = " + memo);
        return memoRepository.save(memo);
    }

    @GetMapping("/api/memos")
    public List<Memo> readMemo(){
        return memoRepository.findAllByOrderByModifiedAtDesc();
    }

    @PostMapping("/api/memos/{id}")
        public Long updateMemo(@PathVariable Long id , @RequestBody MemoRequestDto requestDto){
            memoService.update(id, requestDto);
            return id;
        }

    @PutMapping("api/memos/{id}")
        public Long deleteMemo(@PathVariable Long id , @RequestBody MemoRequestDto requestDto) {
            memoService.delete(id, requestDto);
            return id;
        }

}
