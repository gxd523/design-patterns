package com.gxd.design.patterns.observer.callback;

/**
 * 被观察者
 */
public class Button {
    private OnClickListener onClickListener;

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    /**
     * Button有调用时机
     */
    public void click() {
        onClickListener.onClick();
    }
}
