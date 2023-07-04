package com.example.diary_process.controller.challenge;

import com.example.diary_process.controller.challenge.form.ChallengeRegisterForm;
import com.example.diary_process.entity.challenge.Challenge;
import com.example.diary_process.service.challenge.ChallengeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("daily-diary/challenge")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class ChallengeController {

    @Autowired
    ChallengeService challengeService;

    @GetMapping(value = "/", headers = "AdId")
    public List<Challenge> findChallengeListById(@RequestHeader("AdId") String adId){
        return challengeService.findChallengeListById(adId);
    }

    @PostMapping("/register")
    public void registerChallenge(@RequestBody ChallengeRegisterForm challengeRegisterForm){
        challengeService.registerChallenge(challengeRegisterForm.getName(), challengeRegisterForm.getAdId(), challengeRegisterForm.getUuId());
    }

}
