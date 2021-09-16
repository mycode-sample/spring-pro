package com.sheepfly.springpro.chapter4.section8;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Component;

@Component("hello")
public class UserPlus implements BeanNameAware, ApplicationContextAware {
    private String beanName;
    private ApplicationContext applicationContext;

    @Override
    public void setBeanName(String name) {
        System.out.println("设置bean名称:" + name);
        this.beanName = name;
    }

    public String getBeanName() {
        return beanName;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        if (applicationContext instanceof AbstractApplicationContext) {
            System.out.println("注册关闭钩子");
            ((AbstractApplicationContext) applicationContext).registerShutdownHook();
        }
    }
}
