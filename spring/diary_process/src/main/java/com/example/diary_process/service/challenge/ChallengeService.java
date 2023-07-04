package com.example.diary_process.service.challenge;

import com.example.diary_process.entity.challenge.Challenge;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ChallengeService {
    public List<Challenge> findChallengeListById(String uuid);
    public void registerChallenge(String name, String adid, String uuid);

}
