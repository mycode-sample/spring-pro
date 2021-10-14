package com.sheepfly.springpro.chapter4.section10;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AccessFactoryBeanDirectly {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("section9.xml");
        System.out.println(ctx.getBean("&teacher"));
        System.out.println(ctx.getBean("&student"));
        System.out.println(ctx.getBean("&president"));
        System.out.println(ctx.getBean("&president"));
        System.out.println(ctx.getBean("&president"));
        System.out.println(ctx.getBean("president").hashCode());
        System.out.println(ctx.getBean("president").hashCode());
        System.out.println(ctx.getBean("president").hashCode());
    }
}
