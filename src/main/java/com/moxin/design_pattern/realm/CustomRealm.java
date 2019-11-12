package com.moxin.design_pattern.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @auther moxinHuoHuo
 * @createDate 2019/5/22 13:03
 */
// 实现自定义realm需要继承AuthorizingRealm，并实现两个抽象的方法

public class CustomRealm extends AuthorizingRealm {

    // todo 模拟数据库存储数据
    static Map<String, Object> mapAccount = new HashMap<>();

    static Map<String, Object> mapRoles = new HashMap<>();

    static Map<String, Object> mapPermission = new HashMap<>();

    static {
        // mapAccount.put("moxin", "123456");
        mapAccount.put("moxin", "74b51fcaad9ed803753ef1a8ee48b2f8");
        mapRoles.put("moxin","admin,user");
        mapPermission.put("admin","user:add,user:delete,user:update,user:retrieve,foodTemplate:select");
        mapPermission.put("user","user:retrieve");
    }

    // 验证授权的方法
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        // 获取用户名
        String username = (String) principals.getPrimaryPrincipal();
        // 获取用户对应的角色，只能设置为Set集合
        Set<String> roles = getRolesByUsername(username);
        // 获取角色对应的权限，只能设置为Set集合
        Set<String> permissons = getPermissionByRoles(roles);

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        // 将权限存放在验证信息中
        // 该方法只支持Set集合类型
        authorizationInfo.setStringPermissions(permissons);
        // 将角色存放在验证信息中
        // 该方法只支持Set集合类型
        authorizationInfo.setRoles(roles);
        // 返回验证信息
        return authorizationInfo;
    }

    // todo 模拟从数据库查询
    private Set<String> getRolesByUsername(String username) {

        HashSet<String> roleSet = new HashSet<>();
        // 模拟执行了“select roles from 表名 where username=XXX”，获取roles字段
        String roleString = (String) mapRoles.get(username);
        // 将字段进行切割，如果切割不成功则返回null
        String [] roles = roleString.split(",");
        // 为了防止切割不成功，也会返回原来的数组
        for (String role : roles) {
            roleSet.add(role);
        }



        return roleSet;
    }

    private Set<String> getPermissionByRoles(Set<String> roles) {

        HashSet permissionSet = new HashSet();
        // 一个用户可能有多个角色，循环处理
        for (String role : roles) {
            // 模拟执行了“select permission from 表名 where role=XXX”，获取permission字段
            String permissionString = (String) mapPermission.get(role);
            // 将字段进行切割，如果切割不成功则返回null
            String [] permissions = permissionString.split(",");

            for (String permission : permissions) {
                permissionSet.add(permission);
            }

        }

        return permissionSet;
    }


    // 验证认证的方法
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        String username = (String) token.getPrincipal();

        char[] chars = (char[]) token.getCredentials();

        String userpwd = getPassword(username);

        if (userpwd == null) {
            return null;
        }
        // 此构造方法封装了方法，将明文密码进行加密再与数据库加密密码进行对比，相同不抛出异常，不相同抛出异常
        // param1 账号
        // param2 数据库的加密密码
        // param3 盐值
        // param4 realm的类名
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(username, userpwd, ByteSource.Util.bytes("moxin"), CustomRealm.class.getSimpleName());
        // 返回认证信息
        return authenticationInfo;
    }

    // todo 模拟数据库查询用户操作
    private String getPassword(String username) {
        return (String) mapAccount.get(username);
    }

    public static void main(String[] args) {
        Md5Hash md5Hash = new Md5Hash("123456","moxin",1);
        System.out.println(md5Hash);
    }
}
