package com.moxin.design_pattern;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;

/**
 * @auther moxinHuoHuo
 * @createDate 2019/5/22 10:55
 */
public class ShiroIniRealmTest {

    @Test
    public void Authentication () {

        IniRealm iniRealm = new IniRealm("classpath:iniRealm.ini");

        // todo 构建SecurityManager环境
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(iniRealm);

        // todo 主体提交认证
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();
        AuthenticationToken userToken = new UsernamePasswordToken("moxin","123456");
        subject.login(userToken);

        subject.checkRoles("admin");

        subject.checkPermission("user:delete");




    }

}
