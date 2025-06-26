package org.example;

import jakarta.jms.TextMessage;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MsgProducer {

    private final JmsTemplate jmsTemplate;

    public MsgProducer(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void sendMsg(String destination, String message) {
        jmsTemplate.send(destination,session ->
        {
            TextMessage textMessage = session.createTextMessage(message);
            textMessage.setStringProperty("idempotencyId","idempotency-"+UUID.randomUUID().toString());
            return textMessage;
        });
    }
}
