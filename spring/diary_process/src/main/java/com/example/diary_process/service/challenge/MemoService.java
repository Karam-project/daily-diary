package com.example.diary_process.service.challenge;

import com.example.diary_process.entity.challenge.Memo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MemoService {

    public List<Memo> findMemoList(Long challengeId);

    public Memo findMemo(Long challengeId);

    public String createMemo(Long challengeId, Long stickerId, String title, String content);

    public void modifyMemo(Long memoId, Long stickerId, String title, String content );

    public void deleteMemo(Long memoId);

}
