package com.moxin.design_pattern.pattern.creational.factorymethod;

import java.util.Collection;
import java.util.Iterator;

/**
 * @auther moxinHuoHuo
 * @createDate 2019/5/21 8:56
 */
public class Infant {

    static {
        System.out.println("正在加载Infant类！");
    }


    Infant(){
        System.out.println("正在创建Infant对象！");
    }

    public void climb() {
        System.out.println("The infant is climbing!");
    }

    public void sleep() {
        System.out.println("The infant need to sleep 10 hours!");
    }


    private static Mother mother = new Infant().new Mother();

    private class Mother implements Human {

        public Mother() {
            System.out.println("正在创建Mother对象！");
        }

        @Override
        public void sleep() {
            climb();
            Infant.this.sleep();
            System.out.println("The Mom has only sleep 5 minutes.");
        }
    }

    public static void main(String[] args) {
        mother.sleep();
    }

}
