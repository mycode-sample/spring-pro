package com.sheepfly.springpro.chapter5.section5.demo4;

import com.sheepfly.springpro.chapter5.section5.demo1.AdviceImpl;
import com.sheepfly.springpro.chapter5.section5.demo2.SampleBean;
import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class AspectJDemo {
    public static void main(String[] args) {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("execution(* fun(int))");
        Advice advice = new AdviceImpl();
        Advisor advisor = new DefaultPointcutAdvisor(pointcut, advice);
        SampleBean sampleBean = new SampleBean();
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvisor(advisor);
        proxyFactory.setTarget(sampleBean);
        SampleBean proxy = (SampleBean) proxyFactory.getProxy();
        proxy.f();
        proxy.fun("hello");
        proxy.fun(1);
        proxy.fun();
    }
}
