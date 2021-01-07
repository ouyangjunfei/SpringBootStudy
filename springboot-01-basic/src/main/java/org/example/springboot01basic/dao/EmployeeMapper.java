package org.example.springboot01basic.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.springboot01basic.pojo.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EmployeeMapper {

    List<Employee> getEmployees();

    Employee getEmployeeById(@Param("id") int id);

}
