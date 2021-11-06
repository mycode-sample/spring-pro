package com.sheepfly.springpro.chapter5.section4;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MethodInterceprotImpl implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("===环绕通知开始执行===");
        System.out.println("方法:" + invocation.getMethod().getName());
        Object[] args = invocation.getArguments();
        Object result = invocation.proceed();
        if (args.length > 0) {
            System.out.println("参数:");
            for (Object ele : args) {
                System.out.println(ele);
                if (ele.equals("aix")) {
                    result = "操作系统是aix";
                    break;
                }
            }
        }
        System.out.println("执行结果:" + result);
        System.out.println("===环绕通知执行完成===");
        return result;
    }
}
