package com.gxd.design.patterns.state;

public class CloseState extends State {
    @Override
    public void open() {
        context.setCurrentState(Context.OPEN_STATE);
        context.open();
    }

    @Override
    public void close() {
        System.out.println("关闭电梯门");
    }

    @Override
    public void run() {
        context.setCurrentState(Context.RUN_STATE);
        context.run();
    }

    @Override
    public void stop() {
        System.out.println("关门状态电梯未运行,所以也不能停止...");
    }
}
