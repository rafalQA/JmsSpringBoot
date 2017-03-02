package jmsQueueSender.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import jmsQueueSender.model.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

import static com.jayway.awaitility.Awaitility.await;

/**
 * Created by rpiotrowicz on 2017-02-28.
 */

public class ItemListener {

    private static final Logger logger = LoggerFactory.getLogger(JmsConsumer.class);

    private Item item;
    private ObjectMapper objectMapper;
    private Long timeout;
    private AtomicBoolean isReceived;

    public ItemListener(ObjectMapper objectMapper, Long timeout) {
        this.objectMapper = objectMapper;
        this.timeout = timeout;
        this.isReceived = new AtomicBoolean(false);
    }

    @JmsListener(destination = "gross-queue", containerFactory = "getDefaultContainerFactory")
    public void receivedMessage(String itemText) {

        try {
            this.item = objectMapper.readValue(itemText, Item.class);
            isReceived.getAndSet(true);
        } catch (IOException e) {
            logger.warn("Can't convert to Item message {}", itemText);
        }
    }

    public Item getItem() {
        await().atMost(timeout, TimeUnit.MILLISECONDS).untilTrue(isReceived);

        return item;
    }
}
