package com.example.diary_process.controller.challenge;

import com.example.diary_process.controller.challenge.form.MemoRegisterForm;
import com.example.diary_process.service.challenge.MemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("daily-diary/memo")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class MemoController {

    @Autowired
    MemoService memoService;

    @PostMapping("/register")
    public String createMemo(@RequestBody MemoRegisterForm memoRegisterForm){

        return memoService.createMemo(
                memoRegisterForm.getChallengeId(),
                memoRegisterForm.getStickerId(),
                memoRegisterForm.getTitle(),
                memoRegisterForm.getContent());
    }

}
