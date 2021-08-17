package com.sheepfly.springpro.chapter3.section6;

import org.example.beans.entity.Company;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class CompanyPlus extends Company implements ApplicationContextAware {
    private ApplicationContext ctx;

    public CompanyPlus() {
        System.out.println("init CompanyPlus.");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("set ctx");
        this.ctx = applicationContext;
    }

    public void work() {
        UserPlus user = ctx.getBean("user", UserPlus.class);
        user.work();
    }
}
