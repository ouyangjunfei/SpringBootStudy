package org.example.springboot05shiro.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 基于权限的访问控制示例
 * <p>
 * 要结合数据库表 roles_permissions 理解
 */
@Controller
public class DevelopmentController {

    @RequiresPermissions("dev:java")
    @RequestMapping("/dev/java")
    public String javaTemplate(Model model) {
        model.addAttribute("title", "Java");
        model.addAttribute("msg", "你可以进行Java开发！");
        return "dev";
    }

    @RequiresPermissions("dev:python")
    @RequestMapping("/dev/python")
    public String pythonTemplate(Model model) {
        model.addAttribute("title", "Python");
        model.addAttribute("msg", "你可以进行Python开发！");
        return "dev";
    }

    @RequiresPermissions("read")
    @RequestMapping("/dev/doc")
    public String readTemplate(Model model) {
        model.addAttribute("title", "文档");
        model.addAttribute("msg", "你可以阅读开发文档！");
        return "dev";
    }
}
