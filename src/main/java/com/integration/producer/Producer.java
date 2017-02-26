package com.integration.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by Rafal Piotrowicz on 25.02.2017.
 */
@Component
public class Producer {

    @Value("${jms.queue.destination}")
    private String destination;
    private JmsTemplate jmsTemplate;

    @Autowired
    public Producer(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void send(Object object){
        jmsTemplate.convertAndSend(destination, object);
    }
}
