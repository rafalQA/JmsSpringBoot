package com.integration.JmsClient;

import com.integration.consumer.Consumer;
import com.integration.model.Item;
import com.integration.producer.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Rafal Piotrowicz on 25.02.2017.
 */
@Component
public class JmsClientImpl implements JmsClient{

    private Producer producer;
    private Consumer consumer;

    @Autowired
    public JmsClientImpl(Producer producer, Consumer consumer){
        this.producer = producer;
        this.consumer = consumer;
    }

    @Override
    public void sendItem(Object object) {
        producer.send(object);
    }

    @Override
    public List<Item> getItems() {
        return consumer.getItems();
    }
}
