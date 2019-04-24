package com.gxd.design.patterns.singleton;

/**
 * 双重锁懒汉单例
 */
public class LazySingleton {
    /**
     * 解决办法是给这个单例对象加上volatile修饰符,线程每次使用到被volatile关键字修饰的变量时，都会去堆里拿最新的数据
     */
    private volatile static LazySingleton instance;

    private LazySingleton() {
    }

    /**
     * 这段代码看上去非常完美，但是，，，却有隐患！
     * 问题主要出现在instance = new LazySingleton();这段代码大致需要3步完成：
     * 1、给Singleton实例分配内存
     * 2、调用Singleton()构造函数，初始化成员字段
     * 3、将instance对象指向分配的内存（此时instance就不是null啦~）
     * 但是，步骤2、3的顺序无法保证，如果线程1执行了1、3步骤，正要执行步骤2时，线程2调用了getInstance()，获取到了没有执行第2步的单例对象
     */
    public static LazySingleton getInstance() {
        if (instance == null) {// 同步代码块有性能消耗，加这行后，instance赋过值，就不会走进同步代码块，避免不必要的同步
            synchronized (LazySingleton.class) {
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }
}
