package com.example.diary_process.controller.challenge.form;

import lombok.Builder;
import lombok.Getter;
@Getter
public class MemoRegisterForm {
    private Long challengeId;
    private Long stickerId;

    private String title;
    private String content;

    @Builder
    public MemoRegisterForm( Long challengeId, Long stickerId, String title, String content ){
        this.challengeId = challengeId;
        this.stickerId = stickerId;
        this.title= title;
        this.content = content;
    }
}
