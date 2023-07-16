package com.example.diary_process.controller.diary.form;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class DiaryForm {

    private String uuid;
    private String content;
    private String emotion;

    private MultipartFile file;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate creationDate;

}
