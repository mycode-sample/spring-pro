package com.sheepfly.springpro.part1;

public class MessageProviderImpl implements MessageProvider {
    @Override
    public String getMessage() {
        return "hello world.";
    }
}
