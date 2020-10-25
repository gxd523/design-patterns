package com.gxd.design.patterns.chain.interceptor.impl;

import com.gxd.design.patterns.chain.interceptor.Chain;
import com.gxd.design.patterns.chain.interceptor.Interceptor;
import com.gxd.design.patterns.chain.interceptor.Request;
import com.gxd.design.patterns.chain.interceptor.Response;

import java.util.List;

public class ChainImpl implements Chain {
    private final int index;
    private final List<Interceptor> interceptors;
    public final Request request;

    public ChainImpl(List<Interceptor> interceptors, int index, Request request) {
        this.interceptors = interceptors;
        this.request = request;
        this.index = index;
    }

    @Override
    public Response process(Request request) {
        Interceptor interceptor = interceptors.get(index);

        return interceptor.intercept(new ChainImpl(interceptors, index + 1, request));
    }
}
