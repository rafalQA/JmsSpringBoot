package com.integration.jmsClient;

import com.integration.producer.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Rafal Piotrowicz on 25.02.2017.
 */
@Component
public class JmsClientImpl implements JmsClient {

    private Producer producer;

    @Autowired
    public JmsClientImpl(Producer producer) {
        this.producer = producer;
    }

    @Override
    public void sendItem(Object object) {
        producer.send(object);
    }
}
