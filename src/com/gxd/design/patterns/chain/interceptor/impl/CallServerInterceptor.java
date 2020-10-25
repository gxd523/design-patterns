package com.gxd.design.patterns.chain.interceptor.impl;

import com.gxd.design.patterns.chain.interceptor.Chain;
import com.gxd.design.patterns.chain.interceptor.Interceptor;
import com.gxd.design.patterns.chain.interceptor.Response;

public class CallServerInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) {
        return new Response() {
        };
    }
}
