package com.sheepfly.springpro.chapter3.section3.injects.demo3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConstructorInject {
    public static void main(String[] args) {
        String path = "com/sheepfly/springpro/chapter2/section3/ConstructorInject.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(path);
        UnknownConstructor unknownConstructor = ctx.getBean("unknownConstructor2", UnknownConstructor.class);
        unknownConstructor.f();
        System.out.println("ctx:" + ctx);
    }
}
