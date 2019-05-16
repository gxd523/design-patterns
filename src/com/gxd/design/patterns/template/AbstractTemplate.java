package com.gxd.design.patterns.template;

/**
 * Created by guoxiaodong on 2019-05-05 15:29
 */
public abstract class AbstractTemplate {
    public void startWork() {
        firstStep();
        secondStep();
        thirdStep();
    }

    protected abstract void firstStep();

    protected abstract void secondStep();

    protected abstract void thirdStep();
}
