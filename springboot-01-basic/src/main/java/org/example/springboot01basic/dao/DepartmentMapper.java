package org.example.springboot01basic.dao;


import org.apache.ibatis.annotations.Mapper;
import org.example.springboot01basic.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DepartmentMapper {

    //获取所有部门信息
    List<Department> getDepartments();

    Department getDepartmentById(int id);

}
