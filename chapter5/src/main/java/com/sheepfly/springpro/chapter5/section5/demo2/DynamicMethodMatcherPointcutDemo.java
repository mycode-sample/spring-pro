package com.sheepfly.springpro.chapter5.section5.demo2;

import com.sheepfly.springpro.chapter5.section5.demo1.AdviceImpl;
import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class DynamicMethodMatcherPointcutDemo {
    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory();
        Pointcut pointcut = new DynamicMethodMatcherPointcutImpl();
        Advice advice = new AdviceImpl();
        Advisor advisor = new DefaultPointcutAdvisor(pointcut, advice);
        proxyFactory.addAdvisor(advisor);
        SampleBean sampleBean = new SampleBean();
        proxyFactory.setTarget(sampleBean);
        SampleBean sampleBeanProxy = (SampleBean) proxyFactory.getProxy();
        for (int i = 0; i < 20; i++) {
            sampleBeanProxy.print(i);
            sampleBeanProxy.f();
        }
    }
}
