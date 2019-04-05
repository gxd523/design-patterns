package com.gxd.design.patterns.observer.impl;

import com.gxd.design.patterns.observer.Observer;
import com.gxd.design.patterns.observer.Subject;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by guoxiaodong on 2019/4/5 20:17
 */
public class Observable implements Subject {
    private Set<Observer> observerSet = new HashSet<>();

    @Override
    public void addObserver(Observer observer) {
        observerSet.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observerSet.remove(observer);
    }

    @Override
    public void removeAll() {
        observerSet.clear();
    }

    @Override
    public void notifyAllObservers(Object data) {
        for (Observer observer : observerSet) {
            observer.update(this, data);
        }
    }

    @Override
    public void notify(Observer observer, Object data) {
        observer.update(this, data);
    }
}
