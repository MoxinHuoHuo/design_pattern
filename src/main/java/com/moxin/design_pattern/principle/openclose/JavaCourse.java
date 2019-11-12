package com.moxin.design_pattern.principle.openclose;

import java.math.BigDecimal;

/**
 * @auther lyd
 * @createDate 2019/5/17 9:19
 */
public class JavaCourse implements ICourse {

    private Integer id;
    private String name;
    private BigDecimal price;

    public JavaCourse(Integer id, String name, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public BigDecimal getPrice() {
        return this.price;
    }

    /*public BigDecimal getDiscountPrice() {
        return this.price.multiply(new BigDecimal("0.8"));
    }*/
}
