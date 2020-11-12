package com.gxd.design.patterns.state;

public class StopState extends State {
    @Override
    public void open() {
        context.setCurrentState(Context.OPEN_STATE);
        context.open();
    }

    @Override
    public void close() {
        System.out.println("停止状态电梯门是关闭的,所以不用关闭...");
    }

    @Override
    public void run() {
        context.setCurrentState(Context.RUN_STATE);
        context.run();
    }

    @Override
    public void stop() {
        System.out.println("电梯停止运行");
    }
}
