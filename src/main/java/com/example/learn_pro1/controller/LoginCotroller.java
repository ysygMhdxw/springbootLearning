package com.example.learn_pro1.controller;

import com.example.learn_pro1.service.UserService;
import com.example.learn_pro1.service.UserServiceImp1;
import entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class LoginCotroller {
    private UserService userService = new UserServiceImp1();

        @GetMapping("/login/{username}/{password}")
        public String login(@PathVariable(value = "username", required = true) String username,
                            @PathVariable(value = "password", required = true) String password,
                            HttpSession session) {

            //参数校验
            if (username.length() < 2 || username.length() > 20
                    || password.length() < 2 || password.length() > 20) {
                return "Login failed";
            }

            //请求转发，会话管理
            try {
                session.setAttribute("user", userService.getUser(username, password));
            } catch (RuntimeException e) {
                return "Login failed";
            }
            return "Login successfully";
        }


        @GetMapping("/logout")
        public String logout(HttpSession session) {
            //注销session（在服务器里删除该session）
            session.invalidate();
            return "Logout successfully";
        }
    }
