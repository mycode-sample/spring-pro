package com.sheepfly.springpro.part2.section3.injects.demo3;

import org.example.beans.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("annotationDemo")
public class AnnotationDemo {
    @Autowired
    private User user;

    public void f() {
        System.out.println(user.getName());
    }
}
