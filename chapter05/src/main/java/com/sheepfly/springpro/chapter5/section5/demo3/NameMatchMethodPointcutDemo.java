package com.sheepfly.springpro.chapter5.section5.demo3;

import com.sheepfly.springpro.chapter5.section5.demo1.AdviceImpl;
import com.sheepfly.springpro.chapter5.section5.demo2.SampleBean;
import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;

public class NameMatchMethodPointcutDemo extends NameMatchMethodPointcut {
    public static void main(String[] args) {
        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
        pointcut.addMethodName("fun");
        Advice advice = new AdviceImpl();
        Advisor advisor = new DefaultPointcutAdvisor(pointcut, advice);
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvisor(advisor);
        proxyFactory.setTarget(new SampleBean());
        SampleBean sampleBeanProxy = (SampleBean) proxyFactory.getProxy();
        sampleBeanProxy.f();
        sampleBeanProxy.fun();
        sampleBeanProxy.fun(1);
        sampleBeanProxy.fun("hello");

    }
}
