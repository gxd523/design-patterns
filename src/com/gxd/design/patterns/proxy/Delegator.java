package com.gxd.design.patterns.proxy;

/**
 * 委托者
 */
public class Delegator implements Subject {
    @Override
    public void doSomething() {
        System.out.println("我是委托者,我委托代理者执行此方法.");
    }
}
