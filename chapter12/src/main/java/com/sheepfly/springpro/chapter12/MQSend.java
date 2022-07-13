package com.sheepfly.springpro.chapter12;

import com.sheepfly.springpro.chapter12.listener.MessageSenderListener;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;

public class MQSend {
    private static final String MQ_URL = "tcp://localhost:4000";
    private static final String MQ_NAME = "foo.bar";

    public static void main(String[] args) throws Exception {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(MQ_URL);
        Connection connection = factory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        for (int i = 0; i < 5; i++) {
            startSend(session);
        }
    }

    public static void startSend(Session session) throws Exception {
        MessageSenderListener sender = new MessageSenderListener();
        sender.setSleep(10);
        Queue queue = session.createQueue(MQ_NAME);
        MessageProducer producer = session.createProducer(queue);
        sender.setMessageProducer(producer);
        Thread thread = new Thread(sender);
        thread.start();
    }

}
