package com.sheepfly.springpro.chapter5.section3;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class ServiceInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("start.");
        Object result = invocation.proceed();
        if (result == null) {
            System.out.println("无返回值");
        } else {
            System.out.println(result);
        }
        System.out.println("end.");
        return result;
    }
}
