package com.gxd.design.patterns.singleton;

/**
 * 饿汉单例
 */
public class HungrySingleton {
    private static final HungrySingleton INSTANCE = new HungrySingleton();

    private HungrySingleton() {
    }

    /**
     * 当调用静态方法时,会初始化静态成员变量
     * 如果单例只有一个静态方法getInstance(),则不存在提前初始化问题
     */
    public static void otherStaticMethod() {
        System.out.println("hahaha");
    }

    public static HungrySingleton getInstance() {
        return INSTANCE;
    }
}
