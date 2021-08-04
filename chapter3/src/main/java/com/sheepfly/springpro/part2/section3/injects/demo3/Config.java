package com.sheepfly.springpro.part2.section3.injects.demo3;

import org.example.beans.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component("config")
public class Config {
    @Bean
    public User initUser() {
        User user = new User("zhangsan", 12, 1);
        return user;
    }

    @Bean
    public User checkUser() {
        User user = new User("lisi", 12, 2);
        return user;
    }
}
