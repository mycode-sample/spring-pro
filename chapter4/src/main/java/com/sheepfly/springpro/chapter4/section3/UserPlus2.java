package com.sheepfly.springpro.chapter4.section3;

import org.springframework.beans.factory.annotation.Value;

public class UserPlus2 {
    @Value("zhangsan")
    private String name;

    public UserPlus2() {
        System.out.println("call userPlus2");
    }

    public UserPlus2(String name) {
        System.out.println("call userPlus2(String)");
        this.name = name;
    }

    public void init() {
        System.out.println("调用初始化方法");
    }

    public void destroy() {
        System.out.println("调用销毁方法");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("call setName");
        this.name = name;
    }

}
