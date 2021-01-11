package org.example.springboot06swagger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableAsync
@SpringBootApplication
public class Springboot06SwaggerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot06SwaggerApplication.class, args);
    }

}
