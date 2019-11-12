package com.moxin.design_pattern.dynamicproxy;


import java.lang.reflect.Proxy;

public class Test {

    public static void main(String[] args) {

        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        Infant infant = new Infant();

        Human son = (Human) Proxy.newProxyInstance(infant.getClass().getClassLoader(),
                infant.getClass().getInterfaces(), new Kinsman(infant));

        son.eatRice();
        son.toTheRestroom();
    }




}
