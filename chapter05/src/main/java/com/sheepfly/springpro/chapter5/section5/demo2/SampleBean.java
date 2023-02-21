package com.sheepfly.springpro.chapter5.section5.demo2;

public class SampleBean {
    public void print(int x) {
        System.out.println("调用print:" + x);
    }

    public void f() {
        System.out.println("调用f");
    }

    public void fun() {
        System.out.println("fun");
    }

    @AdviceRequired
    public void fun(String s) {
        System.out.println("fun:s");
    }

    public String fun(int i) {
        System.out.println("fun:int");
        return String.valueOf(i);
    }
}
