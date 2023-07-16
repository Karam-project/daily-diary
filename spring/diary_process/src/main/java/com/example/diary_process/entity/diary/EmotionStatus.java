package com.example.diary_process.entity.diary;

import lombok.Getter;

import java.util.stream.Stream;

@Getter
public enum EmotionStatus {
    HAPPY("행복"),
    EXCITED("신남"),
    BORED("지루함"),
    ANGRY("화남"),
    SAD("슬픔");

    private final String emotion;

    EmotionStatus(String emotion) {
        this.emotion = emotion;
    }

    public static EmotionStatus ofEmotion(String emotion) {

        return Stream.of(values())
                .filter(e -> e.name().equals(emotion))
                .findAny()
                .orElseThrow();
    }
}
