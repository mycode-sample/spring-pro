package com.sheepfly.springpro.part2.section3.injects.demo1;

import com.sheepfly.springpro.part1.MessageProvider;
import com.sheepfly.springpro.part1.MessageProviderImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {
    @Bean
    public MessageProvider provider() {
        return new MessageProviderImpl();
    }
}
