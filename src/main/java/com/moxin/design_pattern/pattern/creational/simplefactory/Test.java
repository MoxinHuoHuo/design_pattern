package com.moxin.design_pattern.pattern.creational.simplefactory;


/**
 * @auther moxinHuoHuo
 * @createDate 2019/5/20 9:36
 */
public class Test {

    public static void main(String[] args) {



        Video video = VideoFactory.getVideo("java");
        video.createVideo();

        Video video1 = VideoFactory.getVideo(FEVideo.class);
        video1.createVideo();

    }
}
