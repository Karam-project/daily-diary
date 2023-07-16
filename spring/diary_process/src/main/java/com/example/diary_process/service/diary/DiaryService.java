package com.example.diary_process.service.diary;

import com.example.diary_process.entity.diary.Diary;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

public interface DiaryService {

    void createDiary(String uuid, String content, String emotion, LocalDate creationDate, MultipartFile file);
    List<Diary> list(String uuid);
}
