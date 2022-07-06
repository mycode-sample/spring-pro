package com.sheepfly.springpro.chapter9;

import com.sheepfly.springpro.chapter7.entity.Singer;
import com.sheepfly.springpro.chapter8.service.SingerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TxAnnotationDemo {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        SingerService singerService = applicationContext.getBean("singerServiceImpl", SingerService.class);
        List<Singer> list = singerService.findAll();
        list.forEach(System.out::println);
    }
}
