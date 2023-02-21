package com.sheepfly.springpro.chapter5.section5.demo1;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

import java.lang.reflect.Method;

public class StaticMethodMatcherPointcutImpl extends StaticMethodMatcherPointcut {
    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        return targetClass == User.class && method.getName().equals("work");
    }

    @Override
    public ClassFilter getClassFilter() {
        return ele -> ele == User.class;
    }
}
