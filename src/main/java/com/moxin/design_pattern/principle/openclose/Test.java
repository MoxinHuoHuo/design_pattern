package com.moxin.design_pattern.principle.openclose;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

/**
 * @auther lyd
 * @createDate 2019/5/17 9:29
 */
@Slf4j
public class Test {

    public static void main(String[] args) {
        ICourse iCourse = new JavaCourse(100,"从0电商入门",new BigDecimal("348"));
        ICourse iCourse1 = new JavaDiscountCourse(100, "从0电商入门", new BigDecimal("348"), new BigDecimal("0.8"));
        JavaDiscountCourse discountCourse = (JavaDiscountCourse) iCourse1;

        log.info("课程id：{}，名称：{}，课程价格：{}", iCourse.getId(), iCourse.getName(), iCourse.getPrice());
        log.info("课程id：{}，名称：{}，课程价格：{}，打折后的价格：{}", discountCourse.getId(), discountCourse.getName(), discountCourse.getPrice(), discountCourse.getDiscountPrice());
    }

}
