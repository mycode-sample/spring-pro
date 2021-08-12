package com.sheepfly.springpro.chapter3.section3.injects.methodsreplace;

import org.example.beans.entity.Company;
import org.example.beans.entity.User;
import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

public class MethodReplacerImpl implements MethodReplacer {
    @Override
    public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
        System.out.println("参数个数:" + args.length);
        System.out.println("方法全限定名:" + method.getName());
        System.out.println("bean全限定名:" + obj.getClass());
        System.out.println("开始处理");
        Class<?>[] parameterTypes = method.getParameterTypes();
        if (parameterTypes[0] == User.class) {
            System.out.println("user:" + ((User) args[0]).getName());
        } else if (parameterTypes[0] == Company.class){
            System.out.println("Company:" + ((Company) args[0]).getName());
        }
        System.out.println("处理完成");
        return null;
    }

}
