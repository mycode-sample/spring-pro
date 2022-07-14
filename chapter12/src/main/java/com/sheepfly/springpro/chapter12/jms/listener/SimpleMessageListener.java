package com.sheepfly.springpro.chapter12.jms.listener;

import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.jms.MessageListener;

@Component
public class SimpleMessageListener implements MessageListener {

    @Override
    public void onMessage(Message message) {
        System.out.println(">>> ===");
        System.out.println("收到消息:" + message);
        System.out.println("<<< ===");
    }
}
