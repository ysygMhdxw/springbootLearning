package com.example.learn_pro1.service;

import entity.User;

import java.util.List;

public interface UserService {
    //根据用户名密码获取用户
    User getUser(String username, String password);

    //获取用户名列表
    List<String> getUsernames();

}
