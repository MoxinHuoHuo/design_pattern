package com.moxin.design_pattern.dynamicproxy;


public class Infant implements Human {


    @Override
    public void eatRice() {
        System.out.println("The infant is eating Rice !");
    }

    @Override
    public void toTheRestroom() {
        System.out.println("The infant is wc !");
    }
}


