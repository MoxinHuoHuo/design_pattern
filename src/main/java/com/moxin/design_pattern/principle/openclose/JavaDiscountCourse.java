package com.moxin.design_pattern.principle.openclose;

import java.math.BigDecimal;

/**
 * @auther lyd
 * @createDate 2019/5/17 9:24
 */
public class JavaDiscountCourse extends JavaCourse {

    private BigDecimal discount;

    public JavaDiscountCourse(Integer id, String name, BigDecimal price, BigDecimal discount) {
        super(id, name, price);
        this.discount = discount;
    }

    public BigDecimal getDiscountPrice(){
        return getPrice().multiply(discount);
    }

}
