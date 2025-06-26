package org.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

@SpringBootApplication
@EnableJms
public class JavaMongoDB implements CommandLineRunner {
    private final MessageProducer messageProducer;
    private final MsgProducer msgProducer;

    public JavaMongoDB(MessageProducer messageProducer, MsgProducer msgProducer) {
        this.messageProducer = messageProducer;
        this.msgProducer = msgProducer;
    }

    @Override
    public void run(String... args) throws Exception {

        for (int i = 1; i <= 10; i++) {
            MyThread myThread = new MyThread(msgProducer,messageProducer,i);
            myThread.setName("MyThread" + i);
            myThread.start();
        }

    }

    public static void main(String[] args) {
        SpringApplication.run(JavaMongoDB.class, args);
    }
}