package org.example.springboot05shiro.service;

import org.example.springboot05shiro.dao.UserMapper;
import org.example.springboot05shiro.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserMapper userMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public List<User> queryAllUsers() {
        return userMapper.queryAllUsers();
    }
}
