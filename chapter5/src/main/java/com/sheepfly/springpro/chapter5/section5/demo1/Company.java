package com.sheepfly.springpro.chapter5.section5.demo1;

public class Company implements Entity {
    @Override
    public void work() {
        System.out.println("开始工作。");
    }

    @Override
    public void complete() {
        System.out.println("完成工作。");
    }
}
