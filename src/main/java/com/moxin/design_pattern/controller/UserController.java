package com.moxin.design_pattern.controller;

import com.moxin.design_pattern.entity.FoodTemplate;
import com.moxin.design_pattern.entity.User;
import com.moxin.design_pattern.form.UserForm;
import com.moxin.design_pattern.service.FoodTemplateService;
import com.moxin.design_pattern.service.ManageUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @auther moxinHuoHuo
 * @createDate 2019/5/25 9:37
 */
@Controller
@RequestMapping("admin")
public class UserController {

    @Autowired
    private FoodTemplateService foodTemplateService;

    @RequiresRoles(value = {"admin","user"},logical = Logical.OR)
    @RequestMapping("AllInfo")
    @ResponseBody
    public String getInformation() {
        return "正在获取全体用户信息...";
    }


    @GetMapping("/foodTemplate")
    @ResponseBody
    public List<FoodTemplate> getFoodTemplateAll(String sellerId, Integer storeId, HttpSession session) {

        User currentUser = (User) session.getAttribute("currentUser");

        if (currentUser == null) {
            throw new RuntimeException("用户没用登录");
        }

        // 获取当前登录用户所属的sellerId和storeId与传参的sellerId和storeId进行比较

        // 相同则说明是这个门店的管理员，不相同则抛出横向越权管理异常

        return foodTemplateService.selectAll(sellerId, storeId);
    }


    @RequestMapping("setAttribute")
    @ResponseBody
    public String setAttribute(User user, HttpSession session, HttpServletResponse response) {
        System.out.println("sessionId:" + session.getId());
        session.setAttribute("currentUser", user);

        Cookie cookie = new Cookie("JSESSIONID", session.getId());
        cookie.setPath("/");
        cookie.setMaxAge(60*30);

        response.addCookie(cookie);

        return "已将信息存入Session中！";
    }

    @RequestMapping("getAttribute")
    @ResponseBody
    public String getAttribute (HttpSession session) {
        System.out.println("sessionId:" + session.getId());
        User currentUser = (User) session.getAttribute("currentUser");
        if (currentUser == null) {
            return "先登录再说话吧！";
        }
        return "将session中的信息获取出来："+currentUser.toString();
    }


}
