package com.bashfan.producer;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

@Component
public class Producer {
    private JmsTemplate jmsTemplate;

    @Autowired
    public void setJmsTemplate(ActiveMQConnectionFactory activeMQConnectionFactory) {
        this.jmsTemplate = new JmsTemplate(activeMQConnectionFactory);
    }

    public void send() {
        jmsTemplate.send("test", new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage("yoyoyo");
            }
        });
    }
}
