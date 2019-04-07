package com.gxd.design.patterns.decorator;

/**
 * Created by guoxiaodong on 2019/4/7 16:04
 */
public class ConcreteDecorator1 extends Decorator {
    public ConcreteDecorator1(Component component) {
        super(component);
    }

    private void doSomethingBefore() {
        System.out.println("ConcreteDecorator1 do something before.");
    }

    @Override
    public void operate() {
        doSomethingBefore();
        super.operate();
    }
}
