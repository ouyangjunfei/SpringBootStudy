package org.example.springboot05shiro.service;

import org.example.springboot05shiro.dao.RoleMapper;
import org.example.springboot05shiro.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    private RoleMapper roleMapper;

    @Autowired
    public void setRoleMapper(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }

    public List<Role> queryAllRoles() {
        return roleMapper.queryAllRoles();
    }

}
