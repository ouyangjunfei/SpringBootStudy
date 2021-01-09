package org.example.springboot05shiro.dao;

import org.apache.ibatis.annotations.Mapper;
import org.example.springboot05shiro.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {

    List<User> queryAllUsers();

}
