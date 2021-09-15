package com.sheepfly.springpro.chapter4.section3;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class BeanDemo {
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public UserPlus2 user() {
        return new UserPlus2();
    }
}
