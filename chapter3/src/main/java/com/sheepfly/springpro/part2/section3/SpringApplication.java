package com.sheepfly.springpro.part2.section3;

import com.sheepfly.springpro.part1.MessageProvider;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                "com/sheepfly/springpro/part2/section3/application.xml");
        System.out.println(ctx.getBean("initUser").toString());
        MessageProvider provider1 = ctx.getBean("provider1", MessageProvider.class);
        System.out.println(provider1.getMessage());
        MessageProvider provider2 = ctx.getBean("provider2", MessageProvider.class);
        System.out.println(provider2.getMessage());

        ComponentScanDemo demo = ctx.getBean("componentScanDemo", ComponentScanDemo.class);
        demo.print();
    }
}
