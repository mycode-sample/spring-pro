package com.sheepfly.springpro.part2.section3.injects.demo3;

import com.sheepfly.springpro.part1.MessageProvider;
import org.example.beans.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("annotationInjectImpl")
public class AnnotationInjectImpl implements MessageProvider {
    @Autowired
    private User user;
    private String message;

    public AnnotationInjectImpl() {
    }

    @Autowired
    public AnnotationInjectImpl(@Value("hello") String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
