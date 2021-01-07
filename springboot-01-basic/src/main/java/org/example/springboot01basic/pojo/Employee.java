package org.example.springboot01basic.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class Employee {

    private Integer id;
    private String name;
    private String email;
    private Integer sex;    //0:女 1:男

    private Department department;
    private Date date;

    public Employee(String name, String email, Integer sex, Department department, Date date) {
        this.name = name;
        this.email = email;
        this.sex = sex;
        this.department = department;
        this.date = date;
    }
}
