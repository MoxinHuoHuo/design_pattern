package com.moxin.design_pattern.pattern.creational.simplefactory;


/**
 * @auther moxinHuoHuo
 * @createDate 2019/5/20 9:36
 */
public class VideoFactory {

    public static Video getVideo(String videoTypeName) {
        if (videoTypeName.equalsIgnoreCase("java")) {
            return new JavaVideo();
        }else if (videoTypeName.equalsIgnoreCase("FE")) {
            return new FEVideo();
        }
        return null;
    }

    public static Video getVideo(Class videoType) {
        Video video = null;
        try {
            video = (Video) videoType.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return video;
    }



}
