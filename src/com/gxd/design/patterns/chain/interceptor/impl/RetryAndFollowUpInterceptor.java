package com.gxd.design.patterns.chain.interceptor.impl;

import com.gxd.design.patterns.chain.interceptor.Chain;
import com.gxd.design.patterns.chain.interceptor.Interceptor;
import com.gxd.design.patterns.chain.interceptor.Request;
import com.gxd.design.patterns.chain.interceptor.Response;

public class RetryAndFollowUpInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) {
        Request request = ((ChainImpl) chain).request;
        return chain.process(request);
    }
}
