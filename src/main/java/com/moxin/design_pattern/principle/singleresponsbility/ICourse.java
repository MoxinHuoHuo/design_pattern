package com.moxin.design_pattern.principle.singleresponsbility;


public interface ICourse {

    // 获取课程内容的接口
    String getCourseName();
    byte [] getCourseVideo();

    // 管理课程的接口
    void studyCourse();
    void refundCourse();

}
