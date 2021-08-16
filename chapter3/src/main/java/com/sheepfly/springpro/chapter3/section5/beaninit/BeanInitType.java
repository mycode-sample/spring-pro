package com.sheepfly.springpro.chapter3.section5.beaninit;

import org.example.beans.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanInitType {
    public static void main(String[] args) {
        String path = "com/sheepfly/springpro/chapter3/section5/beaInitType.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(path);
        User singleUser = ctx.getBean("singleUser", User.class);
        User singleUser2 = ctx.getBean("singleUser", User.class);
        System.out.println(singleUser == singleUser2);
        User noSingleUser = ctx.getBean("noSingleUser", User.class);
        User noSingleUser2 = ctx.getBean("noSingleUser", User.class);
        System.out.println(noSingleUser == noSingleUser2);
        Runnable runnable = () -> {
            System.out.println("thread start");
            User user1 = ctx.getBean("singleUser", User.class);
            User user2 = ctx.getBean("singleUser", User.class);
            System.out.println(user1 == user2);
            User user3 = ctx.getBean("noSingleUser", User.class);
            User user4 = ctx.getBean("noSingleUser", User.class);
            System.out.println(user3 == user4);
        };
        Thread t = new Thread(runnable);
        t.start();
    }
}
