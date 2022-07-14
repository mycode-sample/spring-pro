package com.sheepfly.springpro.chapter12.jms;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;

import java.util.Date;

public class SpringJmsApp {
    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        JmsTemplate jmsTemplate = context.getBean("jmsTemplate", JmsTemplate.class);
        while (true) {
            jmsTemplate.convertAndSend(new Date());
            Thread.sleep(1000);
        }
    }
}
