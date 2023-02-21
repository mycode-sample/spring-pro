package com.sheepfly.springpro.chapter3.section7;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutoWiredBean {
    private static final Logger log = LoggerFactory.getLogger(AutoWiredBean.class);

    public static void main(String[] args) {
        String path = "com/sheepfly/springpro/chapter3/section7/autoWiredBean.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(path);
        DemoBean byType = ctx.getBean("byType", DemoBean.class);
        DemoBean byName = ctx.getBean("byName", DemoBean.class);
        DemoBean byName2 = ctx.getBean("byName2", DemoBean.class);
        DemoBean constructor = ctx.getBean("constructor", DemoBean.class);
        log.info(byType.getClass().getName());
        log.info(byName.getClass().getName());
        log.info(byName2.getClass().getName());
        log.info(constructor.getClass().getName());
    }
}
