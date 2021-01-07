package org.example.springboot01basic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

//在templates目录下的所有页面，只能通过controller跳转
@Controller
public class IndexController {

    @RequestMapping({"/", "/index.html"})
    public String signIn() {
        return "sign_in";
    }

    @RequestMapping("/main.html")
    public String mainHtml() {
        return "dashboard";
    }

    @RequestMapping("/index")
    public String index(Model model) {
        List<String> userList = new ArrayList<>();
        userList.add("张三");
        userList.add("李四");
        userList.add("王五");
        model.addAttribute("userList", userList);
        return "index";
    }

    @RequestMapping("/user.html")
    public String user() {
        return "forward:/user/get";
    }

    @RequestMapping("/login")
    public String login(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
        //具体业务
        if (StringUtils.hasLength(email) && StringUtils.hasLength(password)) {
            session.setAttribute("loginUser", email);
            return "redirect:/main.html";
        } else {
            model.addAttribute("msg", "用户名或密码错误");
            return "index";
        }
    }
}
