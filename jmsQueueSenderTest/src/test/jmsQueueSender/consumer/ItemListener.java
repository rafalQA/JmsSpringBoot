package jmsQueueSender.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import jmsQueueSender.model.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;

import java.io.IOException;

/**
 * Created by rpiotrowicz on 2017-02-28.
 */

public class ItemListener {

    private static final Logger logger = LoggerFactory.getLogger(JmsConsumer.class);

    private Item item;

    @JmsListener(destination = "DEMO-QUEUE", containerFactory = "getDefaultContainerFactory")
    public void receivedMessage(String itemText) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            this.item = objectMapper.readValue(itemText, Item.class);
        } catch (IOException e) {
           logger.warn("Can't convert to Item message {}", itemText);
        }
    }

    public Item getItem() {
        return item;
    }
}
