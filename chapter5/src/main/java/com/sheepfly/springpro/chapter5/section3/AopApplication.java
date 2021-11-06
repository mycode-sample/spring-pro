package com.sheepfly.springpro.chapter5.section3;

import org.springframework.aop.framework.ProxyFactory;

public class AopApplication {
    public static void main(String[] args) {
        Service service = new Service();
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvice(new ServiceInterceptor()); 
        proxyFactory.setTarget(service);
        Service serviceProxy = (Service) proxyFactory.getProxy();
        serviceProxy.doService();
    }
}
