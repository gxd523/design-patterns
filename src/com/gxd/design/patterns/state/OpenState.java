package com.gxd.design.patterns.state;

/**
 * 打开电梯门
 */
public class OpenState extends State {
    @Override
    public void open() {
        System.out.println("打开电梯门");
    }

    @Override
    public void close() {
        context.setCurrentState(Context.CLOSE_STATE);
        context.close();
    }

    @Override
    public void run() {
        System.out.println("开门状态电梯不能运行...");
    }

    @Override
    public void stop() {
        System.out.println("开门状态电梯没有运行,所以不能停止...");
    }
}
