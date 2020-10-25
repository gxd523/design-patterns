package com.gxd.design.patterns.chain.interceptor;

public interface Interceptor {
    Response intercept(Chain chain);
}
