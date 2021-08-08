package com.sheepfly.springpro.chapter3.section3.injects.demo1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

import java.util.Arrays;

@ImportResource("classpath:com/sheepfly/springpro/chapter2/section3/application.xml")
@ComponentScan("com.sheepfly.springpro.chapter3.section3.injects.demo1")
public class JavaInject {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(JavaInject.class);
        System.out.println(ctx.getBeanDefinitionCount());
        Arrays.stream(ctx.getBeanDefinitionNames()).forEach(System.out::println);
    }
}
