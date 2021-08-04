package com.sheepfly.springpro.part2.section3.injects.demo3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CollectionInject {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                "com/sheepfly/springpro/part2/section3/collectionInject.xml");
        CollectionBean collection = ctx.getBean("collection", CollectionBean.class);
        collection.display();
    }
}
