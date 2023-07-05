package com.example.diary_process.controller.user;

import com.example.diary_process.controller.user.form.UserRegisterForm;
import com.example.diary_process.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public void registerUser(@RequestBody UserRegisterForm userRegisterForm){
        userService.registerUser(userRegisterForm.getAdid(), userRegisterForm.getUuid());
    }
}
