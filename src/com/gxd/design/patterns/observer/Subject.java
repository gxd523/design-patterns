package com.gxd.design.patterns.observer;

/**
 * 被观察者
 */
public interface Subject {
    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    void removeAll();

    void notifyAllObservers(Object data);

    void notify(Observer observer,Object data);
}
