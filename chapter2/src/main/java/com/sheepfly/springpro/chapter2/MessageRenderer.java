package com.sheepfly.springpro.chapter2;

public interface MessageRenderer {
    void render() throws Exception;

    MessageProvider getMessageProvider();

    void setMessageProvider(MessageProvider messageProvider);
}
