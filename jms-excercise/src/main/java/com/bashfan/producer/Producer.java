package com.bashfan.producer;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class Producer {
    public static void main() {

        try {
            ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
            activeMQConnectionFactory.setBrokerURL("tcp://localhost:61616");
            Connection connection = activeMQConnectionFactory.createConnection();
            connection.start();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue("jxyu.queue");


            MessageProducer messageProducer =  session.createProducer(destination);
            messageProducer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
            String text = "this is a message from producer2" + Thread.currentThread().getName();
            TextMessage textMessage = session.createTextMessage(text);

            messageProducer.send(textMessage);

        } catch (JMSException e) {
            e.printStackTrace();
        }

    }
}
