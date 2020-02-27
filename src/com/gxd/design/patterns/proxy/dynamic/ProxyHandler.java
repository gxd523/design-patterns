package com.gxd.design.patterns.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by guoxiaodong on 2019/4/5 21:01
 */
public class ProxyHandler implements InvocationHandler {
    /**
     * 真正干活的人
     */
    private Object subject;

    public ProxyHandler(Object subject) {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object obj, Method method, Object[] args) throws Throwable {
        System.out.println("do something before.");
        Object result = method.invoke(subject, args);
        System.out.println("do something after.");
        return result;
    }
}
