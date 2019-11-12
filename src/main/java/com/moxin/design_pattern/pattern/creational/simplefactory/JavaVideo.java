package com.moxin.design_pattern.pattern.creational.simplefactory;

/**
 * @auther moxinHuoHuo
 * @createDate 2019/5/20 9:34
 */
public class JavaVideo implements Video {

    @Override
    public void createVideo() {
        System.out.println("正在创建java视频！");
    }
}
