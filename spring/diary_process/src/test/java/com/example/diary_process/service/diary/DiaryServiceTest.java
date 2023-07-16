package com.example.diary_process.service.diary;

import com.example.diary_process.controller.diary.form.DiaryForm;
import com.example.diary_process.entity.diary.Diary;
import com.example.diary_process.entity.user.User;
import com.example.diary_process.repository.diary.DiaryRepository;
import com.example.diary_process.repository.user.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class DiaryServiceTest {

    @Autowired
    DiaryRepository diaryRepository;

    @Autowired DiaryService diaryService;

    @Autowired
    UserRepository userRepository;

    @AfterEach
    public void afterEach(){
        diaryRepository.deleteAll();
        userRepository.deleteAll();
    }

    @Test
    void creatDiary() {
        String adid = "aabb-ffff-eeee-gggg";
        String uuid = "aabb-ffff-eeee-gggg-fjfkjednfjkl";

        String content = "create diary test";
        String emotion = "HAPPY";
        LocalDate creationDate = LocalDate.parse("2022-01-11");
        MultipartFile file = null;

        User user = User.builder()
                .adid(adid)
                .uuid(uuid).build();
        userRepository.save(user);

        DiaryForm diaryForm = new DiaryForm(uuid, content, emotion, file, creationDate);

        diaryService.create(
                diaryForm.getUuid(),
                diaryForm.getContent(),
                diaryForm.getEmotion(),
                diaryForm.getCreationDate(),
                diaryForm.getFile()
        );
    }

    @Test
    void list() {
        String uuid = "aabb-ffff-eeee-gggg-fjfkjednfjkl";

        List<Diary> diaryList = diaryService.list(uuid);

        for (int i = 0; i < diaryList.size(); i++) {
            System.out.println(diaryList.get(i).getContent());
        }
    }
}
