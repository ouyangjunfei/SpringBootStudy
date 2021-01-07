package org.example.springboot04security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RouterController {
    @RequestMapping({"/", "/index", "/index.html"})
    public String toIndex() {
        return "index";
    }

    @GetMapping("/toLogin")
    public String toLogin() {
        return "views/login";
    }

    @RequestMapping("/{level}/{id}")
    public String toLevel(@PathVariable String level, @PathVariable int id) {
        int i = Integer.parseInt(level.substring(level.length() - 1));
        return "views/level" + i + "/" + id;
    }
}
