package org.example.springboot03mybatis.controller;


import org.example.springboot03mybatis.dao.UserMapper;
import org.example.springboot03mybatis.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    private UserMapper userMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @GetMapping("/get/users")
    public List<User> queryUserList() {
        return userMapper.queryUserList();
    }

    @GetMapping("/get/user/{id}")
    public User queryUserById(@PathVariable int id) {
        return userMapper.queryUserById(id);
    }

    @GetMapping("/add/user/{name}/{pwd}")
    public int addUser(@PathVariable String name, @PathVariable String pwd) {
        Map<String, Object> map = new HashMap<>();
        if (name != null) {
            map.put("name", name);
        }
        if (pwd != null) {
            map.put("pwd", pwd);
        }
        return userMapper.addUser(map);
    }

    @PostMapping("/update/user/{id}")
    public int updateUser(@PathVariable int id, @RequestParam("name") String name, @RequestParam("pwd") String pwd) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        if (name != null) {
            map.put("name", name);
        }
        if (pwd != null) {
            map.put("pwd", pwd);
        }
        return userMapper.updateUser(map);
    }

    @GetMapping("/delete/{id}")
    public int deleteUser(@PathVariable int id) {
        return userMapper.deleteUser(id);
    }
}
