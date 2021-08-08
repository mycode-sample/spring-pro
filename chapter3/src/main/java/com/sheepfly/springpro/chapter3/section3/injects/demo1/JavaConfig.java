package com.sheepfly.springpro.chapter3.section3.injects.demo1;

import com.sheepfly.springpro.chapter2.MessageProvider;
import com.sheepfly.springpro.chapter2.MessageProviderImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {
    @Bean
    public MessageProvider provider() {
        return new MessageProviderImpl();
    }
}
