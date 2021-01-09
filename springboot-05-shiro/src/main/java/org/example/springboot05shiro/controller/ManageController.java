package org.example.springboot05shiro.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ManageController {

    @RequiresPermissions("manage")
    @RequestMapping("/admin/manage")
    public String manageTemplate(Model model) {
        model.addAttribute("msg", "这是管理页面");
        return "manage";
    }
}
