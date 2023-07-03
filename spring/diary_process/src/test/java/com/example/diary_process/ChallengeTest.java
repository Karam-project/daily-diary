package com.example.diary_process;

import com.example.diary_process.entity.challenge.Challenge;
import com.example.diary_process.entity.user.User;
import com.example.diary_process.repository.challenge.ChallengeRepository;
import com.example.diary_process.repository.user.UserRepository;
import com.example.diary_process.service.challenge.ChallengeService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ChallengeTest {

    @Autowired
    ChallengeRepository challengeRepository;

    @Autowired
    ChallengeService challengeService;

    @Autowired
    UserRepository userRepository;

    @AfterEach
    public void afterEach(){
        challengeRepository.deleteAll();
        userRepository.deleteAll();
    }

    @Test
    public void findChallengeListById(){
        String adid1 = "aadd-ffff-eeee-gggg";
        String uuid1 = "aadd-ffff-eeee-gggg-fjfkjednfjkl";

        String adid2 = "33ff-eeef-eeee-gggg";
        String uuid2 = "3444-f44f-eeee-gggg-fjfkjednfjkl";

        User user1 = User.builder()
                .adid(adid1)
                .uuid(uuid1).build();
        userRepository.save(user1);

        User user2 = User.builder().
                uuid(uuid2).
                adid(adid2).build();
        userRepository.save(user2);

        Challenge challenge1 = Challenge.builder()
                .name("물 마시기")
                .user(user1).build();

        challengeRepository.save(challenge1);

        Challenge challenge2 = Challenge.builder()
                .name("책읽기")
                .user(user1).build();
        challengeRepository.save(challenge2);

        List<Challenge> repo = challengeRepository.findByUserUuId(uuid1);
        List<Challenge> result = challengeService.findChallengeListById(uuid1);

        Assertions.assertThat(result.size()).isEqualTo(2);
    }
}
