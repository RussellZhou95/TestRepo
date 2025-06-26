package org.example;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;

public class ThreadTest {
    public static void main(String[] args) {
//        MyThread thread = new MyThread(1);
//        MyThread thread2 = new MyThread(2);
//        MyThread thread3 = new MyThread(3);
//        thread.setName("MyThread 1");
//        thread2.setName("MyThread 2");
//        thread3.setName("MyThread 3");
//        thread.start();
//        thread2.start();
//        thread3.start();
    }


}
@Data
@RequiredArgsConstructor
class MyThread extends Thread implements Runnable {

    private final MessageProducer producer;
    private final int index;

    @Override
    public void run() {
        for (int j = 1; j <=10; j++) {
            producer.sendMessage("test-queue", currentThread().getName() + "'s "+j + " th msg" );
        }

    }
}