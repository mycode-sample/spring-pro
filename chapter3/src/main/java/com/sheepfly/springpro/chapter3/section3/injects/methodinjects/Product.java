package com.sheepfly.springpro.chapter3.section3.injects.methodinjects;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Product {
    private String message = new SimpleDateFormat("yyyyMMdd HH:mm:ss.ssssss")
            .format(new Date());

    public void service() {
        System.out.println("service:" + message);
    }
}
