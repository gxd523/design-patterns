package com.gxd.design.patterns.proxy;

/**
 * 被委托者、被代理者,业务逻辑的具体执行者
 */
public class SubjectImpl implements Subject {
    @Override
    public void doSomething() {
        System.out.println("我是被委托者,我才是真正干活的人.");
    }
}
