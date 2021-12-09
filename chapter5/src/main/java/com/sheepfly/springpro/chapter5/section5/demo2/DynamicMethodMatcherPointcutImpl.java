package com.sheepfly.springpro.chapter5.section5.demo2;

import org.springframework.aop.support.DynamicMethodMatcherPointcut;

import java.lang.reflect.Method;

public class DynamicMethodMatcherPointcutImpl extends DynamicMethodMatcherPointcut {
    @Override
    public boolean matches(Method method, Class<?> targetClass, Object... args) {
        if (args.length > 0) {
            int x = (int) args[0];
            if (x > 10) {
                return true;
            }
        }
        return false;
    }
}
