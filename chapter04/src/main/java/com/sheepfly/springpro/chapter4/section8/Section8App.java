package com.sheepfly.springpro.chapter4.section8;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Section8App {

    public static void main(String[] args) {
        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("section8.xml");
        UserPlus userPlus = ctx.getBean(UserPlus.class);
        System.out.println(userPlus.getBeanName());
    }
}
