package com.sheepfly.springpro.part2.section3;

import com.sheepfly.springpro.part1.MessageProviderImpl;
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
