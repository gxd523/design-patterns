package com.gxd.design.patterns.factory.phone;

/**
 * Created by guoxiaodong on 2019/4/5 14:24
 */
public class SamsungPhone implements Phone {
    @Override
    public void call() {
        System.out.println("SamsungPhone make a call.");
    }

    @Override
    public void sendMessage() {
        System.out.println("SamsungPhone send a message.");
    }
}
