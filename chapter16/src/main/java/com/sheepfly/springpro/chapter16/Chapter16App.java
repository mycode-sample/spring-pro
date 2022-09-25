package com.sheepfly.springpro.chapter16;

import com.sheepfly.springpro.chapter16.entities.Singer;
import com.sheepfly.springpro.chapter16.service.SingerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Chapter16App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.sheepfly.springpro.chapter16");
        for (String ele : context.getBeanDefinitionNames()) {
            System.out.println(ele);
        }
        SingerService service = context.getBean("singerServiceImpl", SingerService.class);
        List<Singer> list = service.findAll();
        System.out.println(list.size());
    }
}
