package com.example.diary_process.repository.challenge;

import com.example.diary_process.entity.challenge.Challenge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChallengeRepository extends JpaRepository<Challenge, Long> {

    @Query("select c from Challenge c join fetch c.user cu where cu.uuid = :userUuId")
    List<Challenge> findByUserUuId(@Param("userUuId") String userUuId);
}
