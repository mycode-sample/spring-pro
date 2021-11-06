package com.sheepfly.springpro.chapter5.section4;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

public class ThrowsAdviceImpl implements ThrowsAdvice {
    public void afterThrowing(Exception e) throws Throwable{
        System.out.println("===异常堆栈开始===");
        e.printStackTrace();
        System.out.println("===异常堆栈结束===");
    }

    public void afterThrowing(Method method, Object args, Object target, ArrayIndexOutOfBoundsException e) {
        System.out.println("==异常：超出范围堆栈开始===");
        e.printStackTrace();
        System.out.println("==异常：超出范围堆栈结束===");
    }
}
