package com.sheepfly.springpro.chapter10;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;

public class ConverterApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        ConversionServiceFactoryBean factoryBean = context.getBean("conversionServiceFactoryBean",
                ConversionServiceFactoryBean.class);
        ConversionService service = factoryBean.getObject();
    }
}
