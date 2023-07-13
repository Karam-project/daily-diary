package com.example.diary_process.controller.challenge;

import com.example.diary_process.controller.challenge.form.MemoRegisterForm;
import com.example.diary_process.entity.challenge.Memo;
import com.example.diary_process.service.challenge.MemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("daily-diary/memo")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class MemoController {

    @Autowired
    MemoService memoService;

    @GetMapping("/")
    public List<Memo> findMemoList(@RequestParam(name = "challengeId", required = false) Long challengeId){
        return memoService.findMemoList(challengeId);
    }

    @GetMapping("/{memoId}")
    public Memo findMemo(@RequestParam(name = "memoId", required = false) Long memoId){
        return memoService.findMemo(memoId);
    }

    @PostMapping("/register")
    public String createMemo(@RequestBody MemoRegisterForm memoRegisterForm){

        return memoService.createMemo(
                memoRegisterForm.getChallengeId(),
                memoRegisterForm.getStickerId(),
                memoRegisterForm.getTitle(),
                memoRegisterForm.getContent());
    }

}
