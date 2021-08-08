package com.sheepfly.springpro.chapter3.section3.injects.methodinjects;

public abstract class AbstractMarket implements DemoBean{
    @Override
    public abstract Product getProduct();

    @Override
    public void doSomething() {
        this.getProduct().service();
    }
}
