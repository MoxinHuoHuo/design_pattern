package com.moxin.design_pattern.principle.dependenceinversion;

import lombok.extern.slf4j.Slf4j;

/**
 * @auther lyd
 * @createDate 2019/5/17 10:13
 */
@Slf4j
public class Test {

    public static void main(String[] args) {
        Linke linke = new Linke();
        String s1 = linke.learnCourse(new JavaCourse());
        String s2 = linke.learnCourse(new FECourse());
        log.info("link正在{}", s1);
        log.info("link正在{}", s2);
    }

}
