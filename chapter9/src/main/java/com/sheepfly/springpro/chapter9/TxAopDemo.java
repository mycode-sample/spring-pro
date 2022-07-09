package com.sheepfly.springpro.chapter9;

import com.sheepfly.springpro.chapter7.entity.Singer;
import com.sheepfly.springpro.chapter8.service.SingerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TxAopDemo {
    private static final Logger log = LoggerFactory.getLogger(TxAopDemo.class);

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-aop.xml");
        System.out.println(context);
        SingerService singerService = context.getBean("singerServiceImpl", SingerService.class);
        List<Singer> list = singerService.findAll();
        System.out.println(list.size());
    }
}
