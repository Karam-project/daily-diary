package com.example.diary_process.entity.diary;

import com.example.diary_process.entity.user.User;
import com.example.diary_process.utility.emotion.EmotionAttributeConverter;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
@Getter
@Setter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Diary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Convert(converter = EmotionAttributeConverter.class)
    @Column(nullable = false)
    private EmotionStatus emotion;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate creationDate;

    @Column
    private String fileName;

    @Builder
    public Diary(String content, User user, EmotionStatus emotion, LocalDate creationDate, String fileName) {
        this.content = content;
        this.user = user;
        this.emotion = emotion;
        this.creationDate = creationDate;
        this.fileName = fileName;
    }
}
