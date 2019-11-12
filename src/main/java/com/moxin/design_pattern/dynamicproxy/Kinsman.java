package com.moxin.design_pattern.dynamicproxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Kinsman implements InvocationHandler {

    Infant son;

    public Kinsman(Infant son) {
        this.son = son;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result;

        System.out.println("Kinsman is Washing hands with his son！");
        result = method.invoke(son, args);
        System.out.println("Kinsman is Wipe mouth with his son！");
        return result;
    }
}
