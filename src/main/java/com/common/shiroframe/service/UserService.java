package com.common.shiroframe.service;


import com.common.shiroframe.dao.UserDao;
import com.common.shiroframe.entity.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
@Slf4j
public class UserService {
    @Autowired
    UserDao userDao;

    public String login(String userName, String password, HttpSession session) {
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(userName, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(usernamePasswordToken);   //完成登录
            UserEntity user = (UserEntity) subject.getPrincipal();
            session.setAttribute("user", user);
            //subject.checkRole(UserEnum.KXJ.getRoleName());
            //subject.checkRole(UserEnum.YS.getRoleName());
            //log.info("欢迎用户:{}登录！",((UserEntity) subject.getPrincipal()).getUserName());
            subject.checkPermission("1");
            log.info("用户：{}拥有：{}权限", ((UserEntity) subject.getPrincipal()).getUserName(), user.getPower());
            return "1";
        } catch (Exception e) {
            log.info("权限不足");
            return "login.html";//返回登录页面
        }
    }
    public UserEntity getUser(String userName) {
        UserEntity userEntity = userDao.getUser(userName);
        if (userEntity != null) {
            return userEntity;
        }
        return null;
    }
}
