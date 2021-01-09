package org.example.springboot05shiro.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    private Integer id;
    private String name;
    private List<String> permissions;
}
