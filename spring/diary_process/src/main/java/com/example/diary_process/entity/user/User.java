package com.example.diary_process.entity.user;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name= "ad_id")
    private String adid;

    @Column(name = "uu_id")
    private String uuid;

    @Builder
    public User(String adid, String uuid){
        this.adid = adid;
        this.uuid = uuid;
    }
}
