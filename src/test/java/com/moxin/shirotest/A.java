package com.moxin.shirotest;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @auther lyd
 * @createDate 2019/8/11 18:56
 */
public class A {

    public Integer number;

    public static void main(String[] args) {

        String timestamp = "1531782000000";

        Long ts = Long.valueOf(timestamp);

        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String time = sdf.format(new Date(ts));

        System.out.println(time);
    }

}

class B extends A{
    public Integer number;
}


