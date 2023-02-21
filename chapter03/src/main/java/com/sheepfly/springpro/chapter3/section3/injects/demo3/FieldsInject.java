package com.sheepfly.springpro.chapter3.section3.injects.demo3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackageClasses = FieldsInject.class)
public class FieldsInject {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(FieldsInject.class);
        AnnotationDemo demo = ctx.getBean("annotationDemo", AnnotationDemo.class);
        demo.f();
    }
}
