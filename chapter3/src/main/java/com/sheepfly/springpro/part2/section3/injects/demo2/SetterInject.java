package com.sheepfly.springpro.part2.section3.injects.demo2;

import com.sheepfly.springpro.part1.MessageRenderer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;

@ComponentScan(basePackageClasses = SetterInject.class)
public class SetterInject {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SetterInject.class);
        System.out.println(ctx.getBeanDefinitionCount());
        Arrays.stream(ctx.getBeanDefinitionNames()).forEach(System.out::println);
        System.out.println("start render----------");
        try {
            MessageRenderer defaultRender = ctx.getBean("defaultRender", MessageRenderer.class);
            defaultRender.render();
            MessageRenderer homeRender = ctx.getBean("homeRender", MessageRenderer.class);
            homeRender.render();
            MessageRenderer autowiredRender = ctx.getBean("autowiredRender", MessageRenderer.class);
            autowiredRender.render();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
