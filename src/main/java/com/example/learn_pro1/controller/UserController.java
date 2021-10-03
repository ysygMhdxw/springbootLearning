package com.example.learn_pro1.controller;

import com.example.learn_pro1.service.UserService;
import com.example.learn_pro1.service.UserServiceImp1;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

public class UserController {
    private UserService userService = new UserServiceImp1();

    @GetMapping("/getUsernames")
    public List<String> getUsernames(HttpSession session){
        //检查是否登录（session是否存在）
        if(session.getAttribute("user") != null) {
            return userService.getUsernames();
        }
        return null;
    }
}
