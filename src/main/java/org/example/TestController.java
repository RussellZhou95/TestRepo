package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/test")
public class TestController {

//    @Autowired
//    private JmsTemplate jmsTemplate;
    @GetMapping()
    public String getCall() throws IOException {
        InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream("idempotency.json");
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(resourceAsStream);
        System.out.println(jsonNode.toString());
        return "There you go";
    }



//    @GetMapping
//    public String test(){
//        jmsTemplate.setExplicitQosEnabled();
//    }
}
