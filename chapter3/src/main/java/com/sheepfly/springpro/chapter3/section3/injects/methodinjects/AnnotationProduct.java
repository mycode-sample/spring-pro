package com.sheepfly.springpro.chapter3.section3.injects.methodinjects;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component("annotationProduct")
@Scope("prototype")
public class AnnotationProduct {
    private String message = new SimpleDateFormat("yyyyMMdd HH:mm:ss.ssssss").format(new Date());

    public void service() {
        System.out.println("service:" + message);
    }
}
