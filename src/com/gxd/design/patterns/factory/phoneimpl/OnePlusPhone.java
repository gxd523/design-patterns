package com.gxd.design.patterns.factory.phoneimpl;

import com.gxd.design.patterns.factory.Phone;

/**
 * Created by guoxiaodong on 2019/4/5 14:21
 */
public class OnePlusPhone implements Phone {
    @Override
    public void call() {
        System.out.println("One Plus Phone make a call.");
    }

    @Override
    public void sendMessage() {
        System.out.println("One Plus Phone send a message.");
    }
}
