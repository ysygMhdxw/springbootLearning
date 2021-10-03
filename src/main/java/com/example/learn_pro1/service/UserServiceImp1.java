package com.example.learn_pro1.service;

import com.example.learn_pro1.dao.UserDao;
import com.example.learn_pro1.dao.UserDaoImp1;
import entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImp1 implements UserService{
    private UserDao userDaoImp1 = new UserDaoImp1();
    @Override
    public User getUser(String username, String password) {
        User user = userDaoImp1.getUserByUsernameAndPassword(username,password);
        if(user == null)throw new RuntimeException();
        return user;
    }

    @Override
    public List<String> getUsernames() {
        return new ArrayList<>(userDaoImp1.getUsernameList());
    }
}
