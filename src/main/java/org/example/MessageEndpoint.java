package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produceMsg")
public class MessageEndpoint {

    @Autowired
    private MessageProducer producer;

    @PostMapping
    public String produceMsg(@RequestBody String message) {
        producer.sendMessage("test-queue",message);
        return "Message sent";
    }
}
