package com.sheepfly.springpro.chapter12.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.TextMessage;

public class MessageReceiverListener implements Runnable {
    private MessageConsumer messageConsumer;
    private long sleep;

    @Override
    public void run() {
        while (true) {
            try {
                Message message = this.messageConsumer.receive();
                TextMessage textMessage = (TextMessage) message;
                System.out.println(MessageSenderListener.format() + " receive message:\r\n" + textMessage.getText());
                Thread.sleep(sleep);
            } catch (JMSException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setSleep(long sleep) {
        this.sleep = sleep;
    }

    public void setMessageConsumer(MessageConsumer messageConsumer) {
        this.messageConsumer = messageConsumer;
    }
}
