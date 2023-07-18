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
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DiaryServiceImpl implements DiaryService {

    @Autowired
    DiaryRepository diaryRepository;

    @Autowired
    UserRepository userRepository;


    @Override
    public void create(String uuid, String content, String emotion, LocalDate creationDate, MultipartFile file) {
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

    @Override
    public List<Diary> list(String uuid) {
        return diaryRepository.findAllByUuid(uuid);
    }

    @Override
    public Diary read(Long id) {
        Diary diary = diaryRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("해당하는 Diary가 없습니다."));
        return diary;
    }

    @Override
    public void delete(Long id) {
        diaryRepository.deleteById(id);
    }

    @Override
    public void modify(Long id, String content, String emotion, LocalDate creationDate, MultipartFile file) {
        Diary diary = diaryRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("해당하는 diary가 없습니다."));

        if (file == null) {
            diary.setContent(content);
            diary.setEmotion(EmotionStatus.ofEmotion(emotion));
            diary.setCreationDate(creationDate);
        } else {
            diary.setContent(content);
            diary.setEmotion(EmotionStatus.ofEmotion(emotion));
            diary.setCreationDate(creationDate);
            diary.setFileName(file.getOriginalFilename());
        }

        diaryRepository.save(diary);
    }
}
