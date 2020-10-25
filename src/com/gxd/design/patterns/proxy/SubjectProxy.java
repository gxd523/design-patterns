package com.gxd.design.patterns.proxy;

/**
 * delegator代替SubjectProxy实现Subject接口
 */
public class SubjectProxy implements Subject {
    private final Subject delegator;

    public SubjectProxy(Subject delegator) {
        this.delegator = delegator;
    }

    private void doBefore() {
    }

    private void doAfter() {
    }

    @Override
    public void doSomething() {
        doBefore();
        delegator.doSomething();
        doAfter();
    }
}
