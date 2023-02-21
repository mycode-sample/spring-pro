package com.sheepfly.springpro.chapter3.section3;

import com.sheepfly.springpro.chapter2.MessageProviderImpl;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class ComponentScanDemo {
    @Resource(name = "provider1")
    private MessageProviderImpl provider;

    public void print() {
        System.out.println("message:" + provider.getMessage());
    }
}
