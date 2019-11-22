package com.gxd.design.patterns.chain;

/**
 * 责任链模式
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
