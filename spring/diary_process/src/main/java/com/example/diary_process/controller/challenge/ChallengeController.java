package com.example.diary_process.controller.challenge;

import com.example.diary_process.controller.challenge.form.ChallengeRegisterForm;
import com.example.diary_process.entity.challenge.Challenge;
import com.example.diary_process.service.challenge.ChallengeService;
import com.example.diary_process.utility.split.JsonSplit;
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

    @GetMapping(value = "/")
    public List<Challenge> findChallengeListById(@RequestParam(value = "uuid", required = false) String uuid){
        String uuId = JsonSplit.splitData(uuid);
        return challengeService.findChallengeListById(uuId);
    }

    @PostMapping("/register")
    public String registerChallenge(@RequestBody ChallengeRegisterForm challengeRegisterForm){
        return challengeService.registerChallenge(
                challengeRegisterForm.getName(),
                challengeRegisterForm.getAdid(),
                challengeRegisterForm.getUuid());
    }

    @DeleteMapping("/{challengeId}")
    public void deleteChallenge(@PathVariable("challengeId") Long challengeId ){
        challengeService.deleteChallenge(challengeId);
    }

}
