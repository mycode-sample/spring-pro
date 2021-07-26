package com.sheepfly.springpro.part1;

public interface MessageRenderer {
    void render() throws Exception;

    MessageProvider getMessageProvider();

    void setMessageProvider(MessageProvider messageProvider);
}
