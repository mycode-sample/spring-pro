package com.sheepfly.springpro.chapter6.section9;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class JdbcTemplateDemo {
    private static final Logger log = LoggerFactory.getLogger(JdbcTemplateDemo.class);
    @Resource(name = "jdbcTemplateRunner")
    private JdbcTemplateRunner runner;

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:section9/spring.xml");
        ctx.refresh();
        log.info("加载完成");
        ctx.getBean("jdbcTemplateDemo", JdbcTemplateDemo.class).runner.work();
    }
}
