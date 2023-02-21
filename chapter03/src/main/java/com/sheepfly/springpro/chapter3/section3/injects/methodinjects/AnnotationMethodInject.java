package com.sheepfly.springpro.chapter3.section3.injects.methodinjects;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackageClasses = AnnotationMethodInject.class)
public class AnnotationMethodInject {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AnnotationMethodInject.class);
        AnnotationAbstractMarket bean = ctx.getBean("annotationAbstractMarket", AnnotationAbstractMarket.class);
        AnnotationProduct product = bean.getProduct();
        AnnotationProduct product2 = bean.getProduct();
        System.out.println(product == product2);
    }
}
