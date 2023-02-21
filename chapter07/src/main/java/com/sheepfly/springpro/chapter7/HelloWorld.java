package com.sheepfly.springpro.chapter7;

import com.sheepfly.springpro.chapter7.dao.SingerDao;
import com.sheepfly.springpro.chapter7.entity.Singer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class HelloWorld {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("helloWorld.xml");
        System.out.println(context.getBeanDefinitionCount());
        SingerDao singleDao = context.getBean("singerDao", SingerDao.class);
        List<Singer> singerList = singleDao.findAll();
        singerList.forEach(System.out::println);
    }
}
