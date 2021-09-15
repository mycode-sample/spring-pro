package com.sheepfly.springpro.chapter4.section3;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ExecuteOnCreating {
    public static void main(String[] args) {
        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("section3.xml");
        String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
        System.out.println("已经定义的bean:");
        for (String ele : beanDefinitionNames) {
            System.out.println(ele);
        }
        ctx.registerShutdownHook();
    }
}
