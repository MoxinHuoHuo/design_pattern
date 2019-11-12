package com.moxin.design_pattern.principle.liskovsubstitution.compositionaggregation;

/**
 * Created by geely
 */
public class ProductDao extends DBConnection{

    /*private DBConnection dbConnection;

    public void setDbConnection(DBConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public void addProduct(){
        String conn = dbConnection.getConnection();
        System.out.println("使用"+conn+"增加产品");
    }*/
    public void addProduct(){
        String conn = super.getConnection();
        System.out.println("使用"+conn+"增加产品");
    }
}
