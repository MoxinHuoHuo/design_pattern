package com.moxin.design_pattern.principle.dependenceinversion;

import java.math.BigDecimal;

/**
 * @auther lyd
 * @createDate 2019/5/17 9:20
 */
public class FECourse implements ICourse {


    @Override
    public String learnCourse() {
        return "正在学习FE课程";
    }
}
