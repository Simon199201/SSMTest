package com.itheima.service.impl;

import com.itheima.domain.User;
import com.itheima.mapper.AccountMapper;
import com.itheima.mapper.UserMapper;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AccountMapper accountMapper;
    public User login(String username, String password) {
        try {
            System.out.println("UserServiceImpl username is " + username + "\tpassword is " + password);
            User user = userMapper.login(username, password);
            System.out.println("user is " + user);
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<User> findAllUser() {
        return userMapper.findAllUser();
    }

    public List<User> findUserByName(String username) {
        return userMapper.findUserByName(username);
    }

    public User findUserAndAccount(String id) {
        return userMapper.findUserAndAccount(id);
    }

    public void deleteUser(String id) {
        accountMapper.deleteAccounts(id);
        userMapper.deleteUser(id);
    }

    public void modifyUser(User user) {
        userMapper.modifyUser(user);
    }

}
