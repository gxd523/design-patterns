package com.gxd.design.patterns.singleton;

/**
 * 这是最安全的实现方式了，无论怎样，这样产生的单例必然是单例
 */
public class StaticSingleton {
    private StaticSingleton() {
    }

    public static StaticSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final StaticSingleton INSTANCE = new StaticSingleton();
    }
}