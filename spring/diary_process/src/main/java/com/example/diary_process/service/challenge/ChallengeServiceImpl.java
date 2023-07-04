package com.example.diary_process.service.challenge;

import com.example.diary_process.entity.challenge.Challenge;
import com.example.diary_process.entity.user.User;
import com.example.diary_process.repository.challenge.ChallengeRepository;
import com.example.diary_process.repository.user.UserRepository;
import com.example.diary_process.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ChallengeServiceImpl implements ChallengeService{

    @Autowired
    ChallengeRepository repository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Override
    public List<Challenge> findChallengeListById(String uuId) {
        return repository.findByUserUuId(uuId);
    }

    @Override
    public void registerChallenge(String name, String adid, String uuid) {

        Optional<User> maybeUser = userRepository.findByUserUuId(uuid);
        if(maybeUser.isPresent()){
            User user = maybeUser.get();

            Challenge challenge = Challenge.builder()
                    .name(name)
                    .user(user)
                    .build();
            repository.save(challenge);
        } else {
            userService.registerUser(adid, uuid);
        }

    }

}
