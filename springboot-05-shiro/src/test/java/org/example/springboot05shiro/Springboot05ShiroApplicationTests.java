package org.example.springboot05shiro;

import org.example.springboot05shiro.dao.RoleMapper;
import org.example.springboot05shiro.dao.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot05ShiroApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Test
    void contextLoads() {
//        System.out.println(userMapper.queryAllUsers());
        System.out.println(roleMapper.queryAllRoles());
    }

}
