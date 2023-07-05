package com.example.diary_process.service.user;

import com.example.diary_process.entity.user.User;
import com.example.diary_process.repository.user.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @AfterEach
    public void afterEach(){
        userRepository.deleteAll();
    }

    @Test
    void registerUser() {
        String adid1 = "aadd-ffff-eeee-gggg";
        String uuid1 = "aadd-ffff-eeee-gggg-fjfkjednfjkl";

        userService.registerUser(adid1, uuid1);

        User user2 = userRepository.findByUserUuId(uuid1).get();

        Assertions.assertThat(uuid1).isEqualTo(user2.getUuid());

    }
}