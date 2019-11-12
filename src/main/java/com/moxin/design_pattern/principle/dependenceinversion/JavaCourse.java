package com.moxin.design_pattern.principle.dependenceinversion;

import java.math.BigDecimal;

/**
 * @auther lyd
 * @createDate 2019/5/17 9:19
 */
public class JavaCourse implements ICourse {


    @Override
    public String learnCourse() {
        return "正在学习Java课程";
    }
}
