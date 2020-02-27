package com.gxd.design.patterns.proxy;

/**
 * 代理者、委托者
 */
public class SubjectProxy implements Subject {
    private Subject delegator;

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
