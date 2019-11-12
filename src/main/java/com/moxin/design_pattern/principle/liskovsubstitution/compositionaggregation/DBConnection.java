package com.moxin.design_pattern.principle.liskovsubstitution.compositionaggregation;

/**
 * Created by geely
 */
public /*abstract*/ class DBConnection {
    public String getConnection(){
        return "MySQL数据库连接";
    }
/*
    public abstract String getConnection();
*/
}
