package com.sheepfly.springpro.chapter12.jms;

import com.sheepfly.springpro.chapter12.jms.listener.MessageReceiverListener;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;

public class MQReceive {
    private static final String MQ_URL = "tcp://localhost:4000";
    private static final String MQ_NAME = "foo.bar";

    public static void main(String[] args) throws Exception {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(MQ_URL);
        Connection connection = factory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        for (int i = 0; i < 5; i++) {
            startReceive(session);
        }
    }

    public static void startReceive(Session session) throws Exception {
        MessageReceiverListener receiver = new MessageReceiverListener();
        receiver.setSleep(10);
        Queue queue = session.createQueue(MQ_NAME);
        MessageConsumer consumer = session.createConsumer(queue);
        receiver.setMessageConsumer(consumer);
        Thread thread = new Thread(receiver);
        thread.start();
    }
}
