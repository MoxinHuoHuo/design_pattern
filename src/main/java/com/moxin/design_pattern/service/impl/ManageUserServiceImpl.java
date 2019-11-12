package com.moxin.design_pattern.service.impl;

import com.moxin.design_pattern.entity.User;
import com.moxin.design_pattern.form.UserForm;
import com.moxin.design_pattern.service.ManageUserService;
import org.springframework.stereotype.Service;

/**
 * @auther moxinHuoHuo
 * @createDate 2019/10/16 14:25
 */
@Service
public class ManageUserServiceImpl implements ManageUserService {

    @Override
    public User selectUserInfoByUsernameAndPassword(UserForm userForm) {

        System.out.println("正在查询user信息");

        return new User();
    }
}
