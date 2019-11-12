package com.moxin.design_pattern.pattern.creational.factorymethod;

/**
 * @auther moxinHuoHuo
 * @createDate 2019/5/21 8:42
 */
public class FEVideoFactory extends VideoFactory {
    @Override
    public Video getVideo() {
        return new FEVideo();
    }
}
