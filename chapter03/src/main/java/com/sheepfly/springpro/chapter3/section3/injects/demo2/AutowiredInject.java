package com.sheepfly.springpro.chapter3.section3.injects.demo2;

import com.sheepfly.springpro.chapter2.MessageProvider;
import com.sheepfly.springpro.chapter2.MessageRenderer;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class AutowiredInject implements MessageRenderer {
    @Resource(name = "autowiredProvider")
    private MessageProvider messageProvider;

    @Override
    public void render() {
        System.out.println(this.getMessageProvider().getMessage());
    }

    @Override
    public MessageProvider getMessageProvider() {
        return this.messageProvider;
    }

    @Override
    public void setMessageProvider(MessageProvider messageProvider) {
        this.messageProvider = messageProvider;
    }
}
