package com.moxin.design_pattern.principle.openclose;

import java.math.BigDecimal;

/**
 * @auther lyd
 * @createDate 2019/5/17 9:20
 */
public class FECourse implements ICourse {

    private Integer id;
    private String name;
    private BigDecimal price;
    private String deception;

    public FECourse(Integer id, String name, BigDecimal price) {
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

    public String getDeception() {
        return deception;
    }

    public void setDeception(String deception) {
        this.deception = deception;
    }
}
