package com.sheepfly.springpro.chapter3.section3.injects.methodinjects;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;

public class MethodInject {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("com/sheepfly/springpro/chapter3/section3/methodinject.xml");
        ctx.refresh();
        MyMarket market = ctx.getBean("market", MyMarket.class);
        AbstractMarket abstractMarket = ctx.getBean("abstractMarket", AbstractMarket.class);

        display("market", market);
        display("abstractMarket", abstractMarket);
    }

    public static void display(String name, DemoBean bean) {
        Product product = bean.getProduct();
        Product product2 = bean.getProduct();
        System.out.println(product);
        System.out.println(product2);
        System.out.println("product == product2 : " + (product == product2));
        product.service();
        product2.service();
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("lookupBean");
        for (int i = 0; i < 10000; i++) {
            Product product3 = bean.getProduct();
        }
        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeNanos());
    }
}
