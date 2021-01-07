package org.example.springboot01basic.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Department {

    private Integer id;
    private String name;

    public Department(String name) {
        this.name = name;
    }
}
