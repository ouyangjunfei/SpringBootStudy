package org.example.springboot05shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用作基于角色认证的示例
 * <p>
 * 只有拥有admin角色的用户才可以访问
 */
@Controller
public class AccountInfoController {

    @RequiresRoles("admin")
    @RequestMapping("/account-info")
    public String accountInfoTemplate(Model model) {

        String name = "World";

        Subject subject = SecurityUtils.getSubject();

        PrincipalCollection principalCollection = subject.getPrincipals();

        if (principalCollection != null && !principalCollection.isEmpty()) {
            name = principalCollection.getPrimaryPrincipal().toString();
        }

        model.addAttribute("name", name);

        return "account-info";
    }

}