package com.sheepfly.springpro.chapter5.section5.demo1;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class StaticMethodMatcherPointcutDemo {
    public static void main(String[] args) {
        Entity userEntity;
        Entity companyEntity;
        Company company = new Company();
        User user = new User();
        Pointcut pointcut = new StaticMethodMatcherPointcutImpl();
        Advice advice = new AdviceImpl();
        Advisor advisor = new DefaultPointcutAdvisor(pointcut, advice);

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvisor(advisor);
        proxyFactory.setTarget(user);
        userEntity = (Entity) proxyFactory.getProxy();

        proxyFactory = new ProxyFactory();
        proxyFactory.addAdvisor(advisor);
        proxyFactory.setTarget(company);
        companyEntity = (Entity) proxyFactory.getProxy();

        userEntity.work();
        userEntity.complete();
        companyEntity.work();
        companyEntity.complete();
    }
}
