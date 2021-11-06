package com.sheepfly.springpro.chapter5.section4;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class AfterReturnAdviceImpl implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("===后置返回通知开始执行===");
        if (returnValue != null) {
            System.out.println("返回值:" + returnValue.toString());
        }
        System.out.println("方法:" + method);
        if (args.length > 0) {
            System.out.println("方法参数");
            for (Object ele : args) {
                System.out.println(ele.toString());
                if (ele.equals("db2")) {
                    throw new NullPointerException("禁止使用db2");
                } else if (ele.equals(1)) {
                    throw new ArrayIndexOutOfBoundsException("超出范围");
                }
            }
        }
        System.out.println("调用对象:" + target);
        System.out.println("===后置返回通知执行完成===");
    }
}
