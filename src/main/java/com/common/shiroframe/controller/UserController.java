package com.common.shiroframe.controller;

import com.common.shiroframe.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.shiro.subject.Subject;
import javax.servlet.http.HttpSession;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public String login(String userName, String password, HttpSession session) {
        return userService.login(userName, password, session);
    }

    @RequestMapping("/logOut")
    public String logOut(HttpSession session) {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
//        session.removeAttribute("user");
        return "login";
    }
}
