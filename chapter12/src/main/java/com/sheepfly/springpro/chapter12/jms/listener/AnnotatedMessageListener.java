package com.sheepfly.springpro.chapter12.jms.listener;

import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

@Component
public class AnnotatedMessageListener {

    @JmsListener(destination = "foo.bar", containerFactory = "jmsContainerFactory")
    public void receive(Message message) {
        if (message instanceof TextMessage) {
            TextMessage textMessage = (TextMessage) message;
            try {
                System.out.println(">>> ===");
                System.out.println("注解类收到消息:" + textMessage.getText());
                System.out.println("<<< ===");
            } catch (JMSException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println(">>> ===");
            System.out.println("注解类收到消息:" + message);
            System.out.println("<<< ===");
        }
    }

    @Bean
    public TextMessage initMessage() {
        return new ActiveMQTextMessage();
    }
}
