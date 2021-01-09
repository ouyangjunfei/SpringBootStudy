package org.example.springboot05shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.example.springboot05shiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public ModelAndView loginTemplate(Model model) {
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("userList", userService.queryAllUsers());
        return modelAndView;
    }

    @PostMapping("/login")
    public String loginAuthentication(@RequestParam("username") String username,
                                      @RequestParam("password") String password,
                                      Model model) {
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        try {
            subject.login(token);
            return "redirect:/";
        } catch (UnknownAccountException uae) {
            model.addAttribute("msg", "用户帐号不正确");
            return "login";
        } catch (IncorrectCredentialsException ice) {
            model.addAttribute("msg", "用户密码不正确");
            return "login";
        } catch (LockedAccountException lae) {
            model.addAttribute("msg", "用户帐号被锁定不可用");
            return "login";
        } catch (AuthenticationException ae) {
            model.addAttribute("msg", "登录失败：" + ae.getMessage());
            return "login";
        }

    }
}