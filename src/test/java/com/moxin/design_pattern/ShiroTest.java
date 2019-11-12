package com.moxin.design_pattern;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @auther moxinHuoHuo
 * @createDate 2019/5/22 9:39
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ShiroTest {

    SimpleAccountRealm accountRealm = new SimpleAccountRealm();

    @Before
    public void initRealm() {
        accountRealm.addAccount("moxin","123456","admin");
    }


    @Test
    public void Authentication () {

        // todo 构建SecurityManager环境
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(accountRealm);

        // todo 主体提交认证
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();
        AuthenticationToken userToken = new UsernamePasswordToken("moxin","123456");
        subject.login(userToken);

        System.out.println("是否认证成功："+subject.isAuthenticated());

        subject.checkRoles("admin");

    }

}
