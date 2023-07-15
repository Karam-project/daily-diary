package com.example.diary_process.controller.diary;

import com.example.diary_process.controller.diary.form.DiaryForm;
import com.example.diary_process.service.diary.DiaryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("daily-diary/diary")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class DiaryController {

    @Autowired
    DiaryService diaryService;

    @PostMapping("/create")
    public void createDiary(@RequestBody DiaryForm diaryForm) {
        diaryService.createDiary(
                diaryForm.getUuid(),
                diaryForm.getContent(),
                diaryForm.getEmotion(),
                diaryForm.getCreationDate(),
                diaryForm.getFile()
        );
    }

}
