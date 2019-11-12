package com.moxin.design_pattern.config.shiro;

import com.moxin.design_pattern.realm.CustomRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @auther moxinHuoHuo
 * @createDate 2019/5/24 13:29
 */
@Configuration
public class ShiroConfig {

    /*@Resource(name = "customRealm")
    CustomRealm customRealm;*/

    @Bean(name = "shiroFilterFactoryBean")
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("defaultWebSecurityManager") SecurityManager securityManager) {

        ShiroFilterFactoryBean filterFactoryBean = new ShiroFilterFactoryBean();
        filterFactoryBean.setSecurityManager(securityManager);
        filterFactoryBean.setUnauthorizedUrl("/error");
        filterFactoryBean.setLoginUrl("/needLogin");

        Map<String, String> filterChainDefinitionMap = new LinkedHashMap();
        filterChainDefinitionMap.put("/admin/*","authc");
        filterChainDefinitionMap.put("/**","anon");

        filterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

        return filterFactoryBean;
    }

    @Bean(name = "defaultWebSecurityManager")
    public SecurityManager getDefaultWebSecurityManager(@Qualifier("customRealm") CustomRealm customRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(customRealm);
        return securityManager;
    }

    @Bean(name = "customRealm")
    public CustomRealm getCustomRealm(@Qualifier("hashedCredentialsMatcher") HashedCredentialsMatcher credentialsMatcher) {
        CustomRealm customRealm = new CustomRealm();
        // 将创建的凭证处理器设置到自定义的realm中
        customRealm.setCredentialsMatcher(credentialsMatcher);
        return customRealm;
    }

    // 创建Hash散列匹配器
    @Bean(name = "hashedCredentialsMatcher" )
    public HashedCredentialsMatcher getHashedCredentialsMatcher() {
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        credentialsMatcher.setHashAlgorithmName("MD5");
        credentialsMatcher.setHashIterations(1);

        return credentialsMatcher;
    }

    // 用于配置开放shiro注解权限判断
    @Bean(name = "authorizationAttributeSourceAdvisor")
    public AuthorizationAttributeSourceAdvisor getAuthorizationAttributeSourceAdvisor(@Qualifier("defaultWebSecurityManager") SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor sourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        sourceAdvisor.setSecurityManager(securityManager);
        return sourceAdvisor;
    }

    // 用于配置开放shiro注解权限判断
    @Bean(name = "lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
        LifecycleBeanPostProcessor lifecycleBeanPostProcessor = new LifecycleBeanPostProcessor();
        return lifecycleBeanPostProcessor;
    }

}
