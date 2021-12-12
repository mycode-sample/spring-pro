package com.sheepfly.springpro.chapter5.section5.demo3;

import com.sheepfly.springpro.chapter5.section5.demo1.AdviceImpl;
import com.sheepfly.springpro.chapter5.section5.demo2.SampleBean;
import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.JdkRegexpMethodPointcut;

public class JdkRegexpMethodPointDemo {
    public static void main(String[] args) {
        JdkRegexpMethodPointcut pointcut = new JdkRegexpMethodPointcut();
        pointcut.setPattern(".*fun$");
        Advice advice = new AdviceImpl();
        Advisor advisor = new DefaultPointcutAdvisor(pointcut, advice);
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvisor(advisor);
        SampleBean sampleBean = new SampleBean();
        proxyFactory.setTarget(sampleBean);
        SampleBean proxy = (SampleBean) proxyFactory.getProxy();
        proxy.f();
        proxy.fun("hello");
        proxy.fun(1);
        proxy.fun();
    }
}
