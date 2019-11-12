package com.moxin.design_pattern.principle.dependenceinversion;

/**
 * @auther lyd
 * @createDate 2019/5/17 10:03
 */
public class Linke {

    public String learnCourse(ICourse iCourse){
        String learning = iCourse.learnCourse();
        return learning;
    }

    /*public String learnJavaCourse(){
        return "正在学习java课程";
    }

    public String learnFECourse(){
        return "正在学习FE课程";
    }*/

}
