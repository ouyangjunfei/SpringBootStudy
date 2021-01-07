package org.example.springboot02druid.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class JDBCController {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //查询数据库的所有信息
    @GetMapping("/get/user")
    public List<Map<String, Object>> getUserList() {
        String sql = "select * from mybatis.user";
        return jdbcTemplate.queryForList(sql);
    }

    @GetMapping("/add/user")
    public int addUser() {
        String sql = "insert into mybatis.user (name, pwd) values ('小明','661322')";
        return jdbcTemplate.update(sql);
    }



}
