package com.sheepfly.springpro.chapter5.section5.demo1;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class AdviceImpl implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("开始执行:" + invocation.getMethod().getName());
        Object result = invocation.proceed();
        System.out.println("执行完成:" + invocation.getMethod().getName());
        return result;
    }
}
