package com.sheepfly.springpro.chapter12.listener;

import org.apache.activemq.command.ActiveMQTextMessage;

import javax.jms.MessageProducer;
import javax.jms.TextMessage;
import java.text.SimpleDateFormat;

public class MessageSenderListener implements Runnable {
    private MessageProducer messageProducer;
    private long sleep;

    public static String format() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.sss");
        return format.format(System.currentTimeMillis());
    }

    @Override
    public void run() {
        try {
            while (true) {
                TextMessage textMessage = new ActiveMQTextMessage();
                textMessage.setText(Thread.currentThread().getName() + ": " + format());
                this.messageProducer.send(textMessage);
                Thread.sleep(sleep);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setMessageProducer(MessageProducer messageProducer) {
        this.messageProducer = messageProducer;
    }

    public void setSleep(long sleep) {
        this.sleep = sleep;
    }
}
