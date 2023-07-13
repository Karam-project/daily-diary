package com.example.diary_process.service.challenge;


import com.example.diary_process.entity.challenge.Challenge;
import com.example.diary_process.entity.challenge.Memo;
import com.example.diary_process.entity.user.User;
import com.example.diary_process.repository.challenge.ChallengeRepository;
import com.example.diary_process.repository.challenge.MemoRepository;
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
    MemoRepository memoRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Override
    public List<Challenge> findChallengeListById(String uuid) {
        return repository.findByUserUuId(uuid);
    }

    @Override
    public String registerChallenge(String name, String adid, String uuid) {
        String msg = "";

        if(repository.findByUserUuId(uuid).size() < 5){
            Optional<User> maybeUser = userRepository.findByUserUuId(uuid);
            if(maybeUser.isEmpty()){
                log.info("user is empty");
            }
            User user = maybeUser.get();

            Challenge challenge = Challenge.builder()
                    .name(name)
                    .user(user)
                    .build();
            repository.save(challenge);
            msg = "챌린지가 등록되었습니다.";
        } else {
            msg = "챌린지는 회원별 최대 5개까지 등록할 수 있습니다.";
        }

        return msg;
    }

    @Override
    public void deleteChallenge(Long challengeId){
        List<Memo> memoList = memoRepository.findByMemoListChallengeId(challengeId);

        for(Memo memo : memoList){
            memoRepository.delete(memo);
        }

        repository.deleteById(challengeId);
    }
}
