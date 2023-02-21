package com.sheepfly.springpro.chapter3.section3.injects.methodsreplace;

import org.example.beans.entity.Company;
import org.example.beans.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MethodReplace {
    public static void main(String[] args) {
        User user = new User();
        user.setName("张三");
        Company company = new Company();
        company.setName("张三的公司");
        DemoBean demoBean = new DemoBean();
        demoBean.display(user);
        demoBean.display(company);

        String path = "com/sheepfly/springpro/chapter3/section3/methodReplace.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(path);
        DemoBean demoBean2 = ctx.getBean("bean", DemoBean.class);
        DemoBean demoBean3 = ctx.getBean("demoBean", DemoBean.class);
        System.out.println("======");
        demoBean2.display(user);
        demoBean2.display(company);
        System.out.println("======");
        demoBean3.display(user);
        demoBean3.display(company);
    }
}
