package com.sheepfly.springpro.chapter3.section3.injects.methodinjects;

public class MyMarket implements DemoBean{
    private Product product;

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public Product getProduct() {
        return this.product;
    }

    @Override
    public void doSomething() {
        product.service();
    }
}
