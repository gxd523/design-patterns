package com.gxd.design.patterns.observer.impl;

import com.gxd.design.patterns.observer.Observer;
import com.gxd.design.patterns.observer.Subject;

/**
 * Created by guoxiaodong on 2019/4/5 20:21
 */
public class Subscriber implements Observer {
    @Override
    public void update(Subject subject, Object data) {
        System.out.println(data.toString());
    }
}
