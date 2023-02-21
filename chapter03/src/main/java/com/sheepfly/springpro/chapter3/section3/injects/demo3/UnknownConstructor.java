package com.sheepfly.springpro.chapter3.section3.injects.demo3;

public class UnknownConstructor {
    private String message;

    public UnknownConstructor() {
    }


    public UnknownConstructor(int arg) {
        this.message = "int:" + arg;
    }
    public UnknownConstructor(String arg) {
        this.message = "string:" + arg;
    }

    public void f() {
        System.out.println(message);
    }
}
