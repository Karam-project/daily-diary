package com.example.diary_process.entity.challenge;

import com.example.diary_process.entity.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public class Challenge {

    @Id
    @Column(name = "challenge_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name ="";

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @CreationTimestamp
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate createDateTime;

    @UpdateTimestamp
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate upDateTime;

    @PrePersist
    public void createDate(){
        this.createDateTime = LocalDate.now();
        this.upDateTime = LocalDate.now();
    }

    @Builder
    public Challenge(String name, User user){
        this.name = name;
        this.user = user;
    }
}
