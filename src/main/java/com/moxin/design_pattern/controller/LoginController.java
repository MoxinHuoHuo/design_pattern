package com.moxin.design_pattern.controller;

import com.moxin.design_pattern.entity.User;
import com.moxin.design_pattern.form.UserForm;
import com.moxin.design_pattern.service.ManageUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @auther moxinHuoHuo
 * @createDate 2019/10/16 17:14
 */
@RestController
public class LoginController {

    @Autowired
    private ManageUserService manageUserService;

    @RequestMapping("needLogin")
    public String needLogin() {

        return "该用户没有登录";
    }

    @RequestMapping("loginVerification")
    public String loginVerification(UserForm userForm, HttpSession session) {

        Subject subject = SecurityUtils.getSubject();

        AuthenticationToken userToken = new UsernamePasswordToken(userForm.getUsername(),userForm.getPassword());

        try {
            subject.login(userToken);
        }catch (AuthenticationException e) {
            System.out.println("认证出错！");
            System.out.println(e.toString());
            return "认证出错！";
        }

        User user = manageUserService.selectUserInfoByUsernameAndPassword(userForm);

        session.setAttribute("currentUser", user);

        return "认证成功！";
    }

}
