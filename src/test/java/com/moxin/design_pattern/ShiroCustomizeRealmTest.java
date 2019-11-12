package com.moxin.design_pattern;

import com.moxin.design_pattern.realm.CustomRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @auther moxinHuoHuo
 * @createDate 2019/5/22 13:18
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ShiroCustomizeRealmTest {


    @Test
    public void Authentication () {

        CustomRealm customizeRealm = new CustomRealm();

        // todo 构建SecurityManager环境
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(customizeRealm);

        // todo 设置Hash加密
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        credentialsMatcher.setHashAlgorithmName("MD5");
        credentialsMatcher.setHashIterations(1);
        customizeRealm.setCredentialsMatcher(credentialsMatcher);

        // todo 主体提交认证
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();
        AuthenticationToken userToken = new UsernamePasswordToken("moxin","123456");
        subject.login(userToken);

        /*subject.checkRole("admin");

        subject.checkPermission("user:add");

        subject.checkPermission("user:delete");
        */
        System.out.println(subject.isAuthenticated());

        subject.checkPermission("user:add");


    }
}
