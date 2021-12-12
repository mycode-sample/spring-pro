package com.sheepfly.springpro.chapter5.section5.demo4;

import com.sheepfly.springpro.chapter5.section5.demo1.AdviceImpl;
import com.sheepfly.springpro.chapter5.section5.demo2.AdviceRequired;
import com.sheepfly.springpro.chapter5.section5.demo2.SampleBean;
import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;

public class AnnoAdviceDemo {
    public static void main(String[] args) {
        Pointcut pointcut = AnnotationMatchingPointcut.forMethodAnnotation(AdviceRequired.class);
        Advice advice = new AdviceImpl();
        Advisor advisor = new DefaultPointcutAdvisor(pointcut, advice);
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvisor(advisor);
        proxyFactory.setTarget(new SampleBean());
        SampleBean proxy = (SampleBean) proxyFactory.getProxy();
        proxy.fun("hello");
        proxy.f();
        proxy.fun(1);
        proxy.fun();
    }
}
