package com.example.diary_process.service.diary;

import com.example.diary_process.controller.diary.form.DiaryForm;
import com.example.diary_process.entity.diary.Diary;
import com.example.diary_process.entity.diary.EmotionStatus;
import com.example.diary_process.entity.user.User;
import com.example.diary_process.repository.diary.DiaryRepository;
import com.example.diary_process.repository.user.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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

    private Long creatDiary() {
        String adid = "aabb-ffff-eeee-gggg";
        String uuid = "aabb-ffff-eeee-gggg-fjfkjednfjkl";

        User user = User.builder()
                .adid(adid)
                .uuid(uuid).build();
        userRepository.save(user);

        String adid1 = "aabb-ffff-eeee-hhhh";
        String uuid1 = "aabb-ffff-eeee-gggg-qweqweqweqwe";

        User user1 = User.builder()
                .adid(adid1)
                .uuid(uuid1).build();
        userRepository.save(user1);

        String content = "create diary test";
        String emotion = "HAPPY";
        LocalDate creationDate = LocalDate.parse("2022-01-11");
        MultipartFile file = null;

        DiaryForm diaryForm = new DiaryForm(uuid, content, emotion, file, creationDate);

        diaryService.create(
                diaryForm.getUuid(),
                diaryForm.getContent(),
                diaryForm.getEmotion(),
                diaryForm.getCreationDate(),
                diaryForm.getFile()
        );

        String content1 = "create diary test1";
        String emotion1 = "SAD";
        LocalDate creationDate1 = LocalDate.parse("2023-07-07");
        MultipartFile file1 = null;

        DiaryForm diaryForm1 = new DiaryForm(uuid1, content1, emotion1, file1, creationDate1);

        diaryService.create(
                diaryForm1.getUuid(),
                diaryForm1.getContent(),
                diaryForm1.getEmotion(),
                diaryForm1.getCreationDate(),
                diaryForm1.getFile()
        );
        Diary diary1 = Diary.builder()
                .content(content1)
                .emotion(EmotionStatus.ofEmotion(emotion1))
                .creationDate(LocalDate.parse("2022-01-01"))
                .build();

        diaryRepository.save(diary1);
        return diary1.getId();
    }

    @Test
    void list() {
        String uuid = "aabb-ffff-eeee-gggg-fjfkjednfjkl";
        creatDiary();
        List<Diary> diaryList = diaryService.list(uuid);
        Assertions.assertThat(diaryList.size()).isEqualTo(1);
    }

    @Test
    void delete() {
        Long id = creatDiary();
        diaryService.delete(id);
        Assertions.assertThat(diaryRepository.findById(id)).isEqualTo(Optional.empty());
    }

    @Test
    void read() {
        Long id = creatDiary();
        Diary diary = diaryService.read(id);
        Assertions.assertThat(diary.getId()).isEqualTo(id);
    }

    @Test
    void modify() {
        Long id = creatDiary();
        String content2 = "modify diary test";
        String emotion2 = "EXCITED";
        LocalDate creationDate2 = LocalDate.parse("2023-07-07");
        MultipartFile file2 = null;

        diaryService.modify(id, content2, emotion2, creationDate2, file2);

        Assertions.assertThat(diaryService.read(id).getEmotion()).isEqualTo(EmotionStatus.ofEmotion(emotion2));
    }
}
