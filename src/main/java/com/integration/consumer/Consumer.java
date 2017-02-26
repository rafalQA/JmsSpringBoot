package com.integration.consumer;

import com.integration.model.Item;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by Rafal Piotrowicz on 25.02.2017.
 */

@Component
public class Consumer {

    private List<Item> items;

    public Consumer() {
        this.items = new ArrayList<>();
    }

    @JmsListener(destination = "DEMO-QUEUE")
    public void receiveMessage(Item item) {
       items.add(item);
    }

    public List<Item> getItems(){
        return items;
    }
}
