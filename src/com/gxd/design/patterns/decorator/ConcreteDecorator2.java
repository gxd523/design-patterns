package com.gxd.design.patterns.decorator;

/**
 * Created by guoxiaodong on 2019/4/7 16:06
 */
public class ConcreteDecorator2 extends Decorator {
    public ConcreteDecorator2(Component component) {
        super(component);
    }

    private void doSomethingAfter() {
        System.out.println("ConcreteDecorator2 do something after.");
    }

    @Override
    public void operate() {
        super.operate();
        doSomethingAfter();
    }
}
