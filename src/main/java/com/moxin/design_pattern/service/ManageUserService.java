package com.moxin.design_pattern.service;

import com.moxin.design_pattern.entity.User;
import com.moxin.design_pattern.form.UserForm;

/**
 * @auther moxinHuoHuo
 * @createDate 2019/10/16 14:24
 */
public interface ManageUserService {

    // 账号密码查询用户信息
    User selectUserInfoByUsernameAndPassword(UserForm userForm);

}
