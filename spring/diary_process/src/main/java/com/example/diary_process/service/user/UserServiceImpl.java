package com.example.diary_process.service.user;


import com.example.diary_process.entity.user.User;
import com.example.diary_process.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public void registerUser(String adid, String uuid){
        if(userRepository.findByUserUuId(uuid).isEmpty() || userRepository.findByUserUuId(uuid) == null){
            User user = User.builder()
                    .adid(adid)
                    .uuid(uuid)
                    .build();
            userRepository.save(user);
        }
    }
}