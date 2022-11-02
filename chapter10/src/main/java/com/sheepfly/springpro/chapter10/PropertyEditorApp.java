package com.sheepfly.springpro.chapter10;

import com.sheepfly.springpro.chapter10.bean.ConnectionPool;
import com.sheepfly.springpro.chapter10.bean.SpringDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PropertyEditorApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        System.out.println(context);
        SpringDataSource springDataSource = context.getBean("springDataSource", SpringDataSource.class);
        System.out.println(springDataSource);
        ConnectionPool connectionPool = context.getBean("connectionPool", ConnectionPool.class);
        System.out.println(connectionPool);
    }
}
