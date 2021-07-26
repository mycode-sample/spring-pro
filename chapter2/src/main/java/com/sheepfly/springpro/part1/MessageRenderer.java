package com.sheepfly.springpro.part1;

public interface MessageRenderer {
    void render() throws Exception;
    void setMessageProvider(MessageProvider messageProvider);
    MessageProvider getMessageProvider();
}
