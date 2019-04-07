package com.gxd.design.patterns.decorator;

/**
 * Created by guoxiaodong on 2019/4/7 16:00
 */
public class ConcreteComponent implements Component {
    @Override
    public void operate() {
        System.out.println("do something.");
    }
}
