package com.example.diary_process.repository.challenge;

import com.example.diary_process.entity.challenge.Memo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemoRepository extends JpaRepository<Memo, Long> {

    @Query("select m from Memo m join fetch m.challenge mc where mc.id =:challengeId")
    List<Memo> findByMemoListChallengeId(@Param("challengeId") Long challengeId);

    @Query("select m from Memo m join fetch m.challenge mc where mc.id =:challengeId order by m.createDateTime desc")
    List<Memo> findByMemoListChallengeIdDesc(@Param("challengeId") Long challengeId);

}

