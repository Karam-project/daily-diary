package com.example.diary_process.service.diary;

import com.example.diary_process.entity.diary.Diary;
import com.example.diary_process.entity.diary.EmotionStatus;
import com.example.diary_process.entity.user.User;
import com.example.diary_process.repository.diary.DiaryRepository;
import com.example.diary_process.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.NoSuchElementException;

@Service
public class DiaryServiceImpl implements DiaryService {

    @Autowired
    DiaryRepository diaryRepository;

    @Autowired
    UserRepository userRepository;


    @Override
    public void createDiary(String uuid, String content, String emotion, LocalDate creationDate, MultipartFile file) {
        User user = userRepository.findByUserUuId(uuid)
                .orElseThrow(() -> new NoSuchElementException("해당하는 user가 없습니다."));

        Diary diary;

        if (file == null) {
            diary = Diary.builder()
                    .user(user)
                    .content(content)
                    .emotion(EmotionStatus.ofEmotion(emotion))
                    .creationDate(creationDate)
                    .build();
        } else {
            diary = Diary.builder()
                    .user(user)
                    .content(content)
                    .emotion(EmotionStatus.ofEmotion(emotion))
                    .creationDate(creationDate)
                    .fileName(file.getOriginalFilename())
                    .build();
        }

        diaryRepository.save(diary);


    }

}
