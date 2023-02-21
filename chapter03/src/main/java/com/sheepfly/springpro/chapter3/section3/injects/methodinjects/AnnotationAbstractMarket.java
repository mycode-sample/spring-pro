package com.sheepfly.springpro.chapter3.section3.injects.methodinjects;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component("annotationAbstractMarket")
public class AnnotationAbstractMarket implements AnnotationDemoBean {

    @Lookup("annotationProduct")
    @Override
    public AnnotationProduct getProduct() {
        System.out.println("调用getProduct烦法。");
        return null;
    }

    @Override
    public void doSomething() {
        getProduct().service();
    }
}
