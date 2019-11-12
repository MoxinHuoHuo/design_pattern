package com.moxin.design_pattern.principle.liskovsubstitution.compositionaggregation;

/**
 * Created by geely
 */
public class MySQLConnection /*extends DBConnection*/ {
    //@Override
    public String getConnection() {
        return "MySQL数据库连接";
    }
}
