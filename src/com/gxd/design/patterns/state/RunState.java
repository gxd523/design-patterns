package com.gxd.design.patterns.state;

public class RunState extends State {
    @Override
    public void open() {
        System.out.println("运行时电梯无法开门...");
    }

    @Override
    public void close() {
        System.out.println("运行时电梯门是关闭的,所以不能再关闭...");
    }

    @Override
    public void run() {
        System.out.println("电梯正在运行");
    }

    @Override
    public void stop() {
        context.setCurrentState(Context.STOP_STATE);
        context.stop();
    }
}
