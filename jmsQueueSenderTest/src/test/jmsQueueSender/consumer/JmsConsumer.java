package jmsQueueSender.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

/**
 * Created by rpiotrowicz on 2017-02-27.
 */

/**
 * This class is only for present to another way consume messages from queue, is not use currently
 */
public class JmsConsumer {

    private static final Logger logger = LoggerFactory.getLogger(JmsConsumer.class);

    private JmsTemplate jmsTemplate;

    @Autowired
    public JmsConsumer(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public String receive() {
        Message message = jmsTemplate.receive();
        getMessageText(message);

        return getMessageText(message);
    }

    private String getMessageText(Message message) {
        String text = "";

        if (message instanceof TextMessage) {
            try {
                text = ((TextMessage) message).getText();
            } catch (JMSException e) {
                logger.error("Can't get text from message", e.getCause());
            }
        } else {
            logger.warn("Message is not type of TextMessage");
        }

        return text;
    }
}
