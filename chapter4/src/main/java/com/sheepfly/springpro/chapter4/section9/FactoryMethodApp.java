package com.sheepfly.springpro.chapter4.section9;

import org.example.beans.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FactoryMethodApp {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("section9.xml");
        System.out.println(ctx.getBean("teacher", User.class).getName());
        System.out.println(ctx.getBean("student", User.class).getName());
        System.out.println(ctx.getBean("president", User.class).getName());
    }
}
