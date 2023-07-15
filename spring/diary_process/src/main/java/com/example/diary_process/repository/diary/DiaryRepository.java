package com.example.diary_process.repository.diary;

import com.example.diary_process.entity.diary.Diary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface DiaryRepository extends JpaRepository<Diary, Long> {

    @Query("select d from Diary d where d.user.uuid = :uuid")
    List<Diary> findAllByUuid(@RequestParam("uuid") String uuid);

}
