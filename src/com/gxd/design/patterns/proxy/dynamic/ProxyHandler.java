package com.gxd.design.patterns.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by guoxiaodong on 2019/4/5 21:01
 */
public class ProxyHandler implements InvocationHandler {
    /**
     * 委托对象
     */
    private Object delegator;

    public ProxyHandler(Object delegator) {
        this.delegator = delegator;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("do something before.");
        Object result = method.invoke(delegator, args);
        System.out.println("do something after.");
        return result;
    }
}
