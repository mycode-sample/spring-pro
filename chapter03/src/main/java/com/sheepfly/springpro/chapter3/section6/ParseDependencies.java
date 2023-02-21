package com.sheepfly.springpro.chapter3.section6;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ParseDependencies {
    public static void main(String[] args) {
        String path = "com/sheepfly/springpro/chapter3/section6/parseDependencies.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(path);
        CompanyPlus company = ctx.getBean("company", CompanyPlus.class);
        company.work();
    }
}
