package org.example;

import jakarta.jms.Message;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import jakarta.jms.JMSException;
import jakarta.jms.TextMessage;

@Component
public class MessageListener {

    @JmsListener(destination = "test-queue")
    public void receiveMessage(String message) {
        System.out.println("Received message: " + message);
    }

    @JmsListener(destination = "test-queue2")
    public void receiveMessage2(Message msg) throws JMSException {
        if(msg instanceof TextMessage ) {
            TextMessage textMessage = (TextMessage) msg;
            String stringMsg = textMessage.getText();
            System.out.println("Received message: "+stringMsg);
        }
    }
}
