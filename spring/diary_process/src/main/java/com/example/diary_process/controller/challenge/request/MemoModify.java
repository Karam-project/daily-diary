package com.example.diary_process.controller.challenge.request;

import lombok.Builder;
import lombok.Getter;

@Getter
public class MemoModify {
    private Long stickerId;

    private String title;
    private String content;

    @Builder
    public MemoModify( Long stickerId, String title, String content ){
        this.stickerId = stickerId;
        this.title= title;
        this.content = content;
    }
}
