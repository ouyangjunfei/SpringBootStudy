package org.example.springboot01basic;

import org.example.springboot01basic.config.DruidDataSourceConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot01BasicApplicationTests {

    @Autowired
    private DruidDataSourceConfig druidDataSourceConfig;

    @Test
    void contextLoads() {
        System.out.println(druidDataSourceConfig);
    }

}
