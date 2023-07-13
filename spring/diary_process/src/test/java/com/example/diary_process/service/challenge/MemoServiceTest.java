package com.example.diary_process.service.challenge;

import com.example.diary_process.entity.challenge.Challenge;
import com.example.diary_process.entity.challenge.Memo;
import com.example.diary_process.entity.user.User;
import com.example.diary_process.repository.challenge.ChallengeRepository;
import com.example.diary_process.repository.challenge.MemoRepository;
import com.example.diary_process.repository.user.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class MemoServiceTest {


    @Autowired
    MemoRepository memoRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ChallengeRepository challengeRepository;

    @Autowired
    MemoService memoService;

    @AfterEach
    public void afterEach(){
        memoRepository.deleteAll();
        challengeRepository.deleteAll();
        userRepository.deleteAll();
    }

    @Test
    void findMemoList() {

        User user = User.builder()
                .adid("fjkh-ffkdh-fnfkdl")
                .uuid("1234-5555-6666")
                .build();
        userRepository.save(user);

        Challenge challenge = Challenge.builder()
                .name("일기")
                .user(user)
                .build();
        challengeRepository.save(challenge);

        Memo memo = Memo.builder().challenge(challenge)
                .stickerId(1L)
                .title("메모")
                .content("메모일기")
                .build();
        memoRepository.save(memo);

        List<Memo> memoList = memoService.findMemoList(challenge.getId());
        System.out.println(memoList.get(0).getTitle());
        Assertions.assertThat(memoList.size()).isEqualTo(1);

    }


    @Test
    void createMemo() {
        User user = User.builder()
                .adid("fjkh-ffkdh-fnfkdl")
                .uuid("1234-5555-6666")
                .build();
        userRepository.save(user);

        Challenge challenge = Challenge.builder()
                .name("일기")
                .user(user)
                .build();
        challengeRepository.save(challenge);

        String msg1 =  memoService.createMemo(challenge.getId(), 1L, " 12일 메모 추가", "12일 메모");
        String expectMsg1 = "메모가 등록되었습니다.";
        Assertions.assertThat(msg1).isEqualTo(expectMsg1);


        String msg2 =  memoService.createMemo(challenge.getId(), 1L, " 12일 메모 추가테스트", "12일 메모 추가");
        String expectMsg2 = "챌린지별 메모는 하루 한개만 등록 가능합니다.";
        Assertions.assertThat(msg2).isEqualTo(expectMsg2);

    }

}