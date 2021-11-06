package com.sheepfly.springpro.chapter5.section4;

import org.springframework.aop.framework.ProxyFactory;

public class AdviceDemo {
    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory();
        SessionManagement sessionManagement = new SessionManagement();
        proxyFactory.setTarget(sessionManagement);
        proxyFactory.addAdvice(new BeforeAdviceImpl());
        SessionManagement proxy = (SessionManagement) proxyFactory.getProxy();
        proxy.addSession("mybatis");
        proxy.addSession("sqlserver");
        proxy.addSession("mysql");

        proxyFactory.addAdvice(new AfterReturnAdviceImpl());
        proxy.doService(0, "what");
        proxy.doService(0, "db2");
        proxy.doService(0, "mybatis");
        System.out.println("***");

        proxyFactory.addAdvice(new MethodInterceprotImpl());
        proxy.doService(0, "aix");
        proxy.doService(0, "success");
        System.out.println("***");

        proxyFactory.addAdvice(new ThrowsAdviceImpl());
        proxy.removeSession(1);
        proxy.addSession("db2");
    }
}
