package com.sheepfly.springpro.chapter8;

import org.springframework.context.support.GenericXmlApplicationContext;

public class JpaHelloWorld {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:jpa.xml");
        context.refresh();
    }
}
