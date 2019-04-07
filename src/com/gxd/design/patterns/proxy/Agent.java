package com.gxd.design.patterns.proxy;

/**
 * 代理者
 */
public class Agent implements Subject {
    private Subject delegator;

    public Agent(Subject delegator) {
        this.delegator = delegator;
    }

    @Override
    public void doSomething() {
        delegator.doSomething();
    }
}
