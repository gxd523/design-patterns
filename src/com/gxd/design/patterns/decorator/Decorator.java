package com.gxd.design.patterns.decorator;

/**
 * Created by guoxiaodong on 2019/4/7 16:02
 */
public abstract class Decorator implements Component {
    private Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void operate() {
        this.component.operate();
    }
}
