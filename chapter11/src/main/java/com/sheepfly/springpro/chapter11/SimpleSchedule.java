package com.sheepfly.springpro.chapter11;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class SimpleSchedule {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-task.xml");
        System.out.println(context);
    }

}
