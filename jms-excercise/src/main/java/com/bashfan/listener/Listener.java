package com.bashfan.listener;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class Listener {
    private static ActiveMQConnectionFactory activeMQConnectionFactory;
    private static Connection connection;
    private static Session session;
    public static void main() throws Exception {


        try {
            activeMQConnectionFactory = new ActiveMQConnectionFactory();
            activeMQConnectionFactory.setBrokerURL("tcp://localhost:61616");
            connection = activeMQConnectionFactory.createConnection();
            connection.start();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue("jxyu.queue");
            MessageConsumer messageConsumer = session.createConsumer(destination);


            while (true) {

                Message message = messageConsumer.receive();

                if (message instanceof TextMessage && message != null) {
                    TextMessage textMessage = (TextMessage) message;
                    String text = textMessage.getText();
                    System.out.println(text);
                } else {
                    System.out.println(message);
                }
            }


        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            session.close();
            connection.close();
        }
    }
}
