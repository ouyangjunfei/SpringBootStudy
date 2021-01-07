package org.example.springboot01basic.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EmployeeMapperTest {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Test
    void getEmployees() {
        System.out.println(employeeMapper.getEmployees());
    }

    @Test
    void getEmployeeById() {
    }
}