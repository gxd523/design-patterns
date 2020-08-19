package com.gxd.design.patterns.proxy.dynamic;

import com.gxd.design.patterns.proxy.Subject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public final class $Proxy0 extends Proxy implements Subject {
    private static Method m0;
    private static Method m1;
    private static Method m2;
    /**
     * Subject.doSomething()
     */
    private static Method m3;

    public $Proxy0(InvocationHandler arg0) {
        super(arg0);
    }

    @Override
    public void doSomething() {
        try {
            m3 = Subject.class.getMethod("doSomething");
            h.invoke(this, m3, m3.getParameters());
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
