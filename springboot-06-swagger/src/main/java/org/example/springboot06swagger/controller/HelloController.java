package org.example.springboot06swagger.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.example.springboot06swagger.pojo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "HelloController", tags = "你好样例的控制器")
@RestController
public class HelloController {

    @ApiOperation("你好示例")
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @ApiOperation("前缀为/api的你好示例")
    @GetMapping("/api/hello")
    public String apiHello() {
        return "hello";
    }

    @ApiOperation("根据ID获取用户")
    @ApiImplicitParam(name = "id", value = "用户的ID", paramType = "query", dataType = "Integer")
    @PostMapping("/get/user")
    public User getUserById(@RequestParam(value = "id", required = false) Integer id) {
        if (id == null) {
            return new User();
        } else {
            // 具体的查询
            return new User(id, "欧阳", "123456");
        }
    }
}
