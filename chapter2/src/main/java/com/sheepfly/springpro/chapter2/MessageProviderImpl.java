package com.sheepfly.springpro.chapter2;

public class MessageProviderImpl implements MessageProvider {

    private String message;

    @Override
    public String getMessage() {
        return this.message == null ? "hello world" : this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
