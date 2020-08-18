package com.gxd.design.patterns.observer;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by guoxiaodong on 2019/4/5 20:17
 */
public class Observable {
    private final Set<Observer> observerSet = new HashSet<>();

    public void addObserver(Observer observer) {
        observerSet.add(observer);
    }

    public void removeObserver(Observer observer) {
        observerSet.remove(observer);
    }

    public void removeAll() {
        observerSet.clear();
    }

    public void notifyAllObservers(Object data) {
        for (Observer observer : observerSet) {
            observer.update(data);
        }
    }

    public void notify(Observer observer, Object data) {
        observer.update(data);
    }
}
