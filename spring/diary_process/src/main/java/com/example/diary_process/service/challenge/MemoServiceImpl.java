package com.example.diary_process.service.challenge;

import com.example.diary_process.entity.challenge.Challenge;
import com.example.diary_process.entity.challenge.Memo;
import com.example.diary_process.repository.challenge.ChallengeRepository;
import com.example.diary_process.repository.challenge.MemoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class MemoServiceImpl implements MemoService {

    @Autowired
    MemoRepository memoRepository;

    @Autowired
    ChallengeRepository challengeRepository;

    @Override
    public List<Memo> findMemoList(Long challengeId) {
        return memoRepository.findByMemoListChallengeId(challengeId);
    }

    @Override
    public Memo findMemo(Long memoId) {
        Optional<Memo> maybeMemo = memoRepository.findById(memoId);
        if(maybeMemo.isEmpty()){
            log.info("memoId is Empty");
        }
        Memo memo = maybeMemo.get();

        return memo;
    }

    @Override
    public String createMemo(Long challengeId, Long stickerId, String title, String content) {
        Memo recentMemo;
        boolean todayFirstFlag = true;
        String msg = "";
        LocalDate today = LocalDate.now();

        if(memoRepository.findByMemoListChallengeIdDesc(challengeId).size() != 0){
            recentMemo = memoRepository.findByMemoListChallengeIdDesc(challengeId).get(0);
            if(recentMemo.getCreateDateTime().isEqual(today)) todayFirstFlag = false;
        }

        if(todayFirstFlag){
            if(memoRepository.findByMemoListChallengeId(challengeId).size() < 30){
                Optional<Challenge> maybeChallenge = challengeRepository.findById(challengeId);

                if(maybeChallenge.isEmpty() || maybeChallenge.equals(Optional.empty())){
                    log.info("challengeId is Empty");
                }
                Challenge challenge = maybeChallenge.get();

                Memo memo = Memo.builder().challenge(challenge)
                        .stickerId(stickerId)
                        .title(title)
                        .content(content)
                        .build();
                memoRepository.save(memo);
                msg = "메모가 등록되었습니다.";
            } else {
                msg = "챌린지별 최대 30개까지 메모 생성이 가능합니다.";
            }
        } else {
            msg = "챌린지별 메모는 하루 한개만 등록 가능합니다.";
        }

        return msg;
    }

    @Override
    public void modifyMemo(Long memoId, Long stickerId, String title, String content) {
        Optional<Memo> maybeMemo = memoRepository.findById(memoId);
        if (maybeMemo.isEmpty()) {
            log.info("Can't modify memo");
        }
        Memo memo = maybeMemo.get();
        memo.setStickerId(stickerId);
        memo.setTitle(title);
        memo.setContent(content);
        memoRepository.save(memo);
    }

    @Override
    public void deleteMemo(Long memoId) {
        memoRepository.deleteById(memoId);
    }


}
