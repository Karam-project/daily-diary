package com.example.diary_process.service.user;

import org.springframework.stereotype.Service;

@Service
public interface UserService {

    public void registerUser(String adid, String uuid);

}
