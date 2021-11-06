package com.sheepfly.springpro.chapter5.section4;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class BeforeAdviceImpl implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("===前置通知开始执行===");
        System.out.println("调用的方法:" + method.getName());
        if (args.length > 0) {
            System.out.println("方法参数:");
            for (Object ele : args) {
                System.out.println(ele);
            }
        }
        System.out.println("调用对象:" + target);
        System.out.println("===前置通知执行完成===");
    }
}
