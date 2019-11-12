package com.moxin.design_pattern.pattern.creational.factorymethod;


/**
 * @auther moxinHuoHuo
 * @createDate 2019/5/20 9:36
 */
public class Test {

    public static void main(String[] args) {

        Video video = new JavaVideoFactory().getVideo();

        Video video1 = new FEVideoFactory().getVideo();

        video.createVideo();

        video1.createVideo();


    }
}
