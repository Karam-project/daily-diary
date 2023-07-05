package com.example.diary_process.controller.challenge.form;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ChallengeRegisterForm {
    private String name;
    private String adid;
    private String uuid;

    @Builder
    public ChallengeRegisterForm(String name, String adid, String uuid){
        this.name = name;
        this.adid = adid;
        this.uuid = uuid;
    }
}
