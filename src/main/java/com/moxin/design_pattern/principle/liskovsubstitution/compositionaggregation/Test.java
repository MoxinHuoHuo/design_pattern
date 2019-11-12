package com.moxin.design_pattern.principle.liskovsubstitution.compositionaggregation;

/**
 * Created by geely
 */
public class Test {
    public static void main(String[] args) {
        ProductDao productDao = new ProductDao();
        // productDao.setDbConnection(new PostgreSQLConnection());
        productDao.addProduct();
    }
}
