package org.example.springboot03mybatis.dao;

import org.apache.ibatis.annotations.Mapper;
import org.example.springboot03mybatis.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface UserMapper {

    List<User> queryUserList();

    User queryUserById(int id);

    int addUser(Map<String, Object> map);

    int updateUser(Map<String, Object> map);

    int deleteUser(int id);

}
