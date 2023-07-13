package com.example.diary_process.service.challenge;

import org.springframework.stereotype.Service;

@Service
public interface MemoService {

    public String createMemo(Long challengeId, Long stickerId, String title, String content);

}
