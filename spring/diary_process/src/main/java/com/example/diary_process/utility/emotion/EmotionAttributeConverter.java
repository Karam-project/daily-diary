package com.example.diary_process.utility.emotion;

import com.example.diary_process.entity.diary.EmotionStatus;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class EmotionAttributeConverter implements AttributeConverter<EmotionStatus, String> {

    // enum을 DB에 어떤 값으로 넣을 것인지 정의
    @Override
    public String convertToDatabaseColumn(EmotionStatus emotionStatus) {
        if (emotionStatus == null) {
            return null;
        }
        return emotionStatus.name();
    }

    // DB에 읽힌 값에 따라 어떻게 enum과 매칭시킬 것인지 정의
    @Override
    public EmotionStatus convertToEntityAttribute(String emotion) {
        if (emotion == null) {
            return null;
        }
        return EmotionStatus.ofEmotion(emotion);
    }
}
