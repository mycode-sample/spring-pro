package com.sheepfly.springpro.chapter5.section5.demo3;

import org.springframework.aop.support.NameMatchMethodPointcut;

public class NameMatchMethodPointcutDemo extends NameMatchMethodPointcut {
    public static void main(String[] args) {
        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
        pointcut.addMethodName("fun");
        pointcut.addMethodName("f");
    }
}
