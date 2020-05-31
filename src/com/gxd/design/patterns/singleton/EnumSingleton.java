package com.gxd.design.patterns.singleton;

/**
 * 最优
 * 1、写法最简单
 * 2、线程安全
 * 3、懒加载
 * 4、避免反射等方法破坏单例
 */
public enum EnumSingleton {
    INSTANCE
}
