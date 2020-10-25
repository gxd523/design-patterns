package com.gxd.design.patterns.chain.event;

/**
 * 责任链模式
 * 类似递归，dispatchEvent()内调用dispatchEvent()
 * 只是dispatchEvent()所属的对象不是同一个
 */
public abstract class EventHandler {
    private EventHandler nextHandler;

    public boolean dispatchEvent(Event event) {
        if (consumeEvent(event)) {
            return true;
        } else {
            if (nextHandler != null) {
                return nextHandler.dispatchEvent(event);
            } else {
                System.out.println("no body handle event!");
                return false;
            }
        }
    }

    public void setNextHandler(EventHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    protected abstract boolean consumeEvent(Event event);
}
