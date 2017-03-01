package jmsQueueSender.config;

import jmsQueueSender.consumer.ItemListener;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.connection.SingleConnectionFactory;

import javax.jms.ConnectionFactory;

/**
 * Created by rpiotrowicz on 2017-02-27.
 */
@Configuration
@EnableJms
public class ActiveMqConfiguration {

    @Value("${activemq.broker-url}")
    private String brokerUrl;
    @Value("${activemq.user}")
    private String brokerUserName;
    @Value("${activemq.password}")
    private String brokerPassword;
    @Value("${jms.queue.destination}")
    private String destination;

    private ConnectionFactory getActiveMqConnectionFactory() {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(brokerUrl);
        factory.setUserName(brokerUserName);
        factory.setPassword(brokerPassword);

        return new SingleConnectionFactory(factory);
    }
/*
    private JmsTemplate getJmsTemplate() {
        JmsTemplate jmsTemplate = new JmsTemplate(getActiveMqConnectionFactory());
        jmsTemplate.setDefaultDestinationName(destination);

        return jmsTemplate;
    }

    @Bean
    public JmsConsumer jmsConsumer() {
        return new JmsConsumer(getJmsTemplate());
    }*/

    @Bean
    public ItemListener getItemListener(){
        return new ItemListener();
    }

    @Bean
    public DefaultJmsListenerContainerFactory getDefaultContainerFactory(){
        DefaultJmsListenerContainerFactory container = new DefaultJmsListenerContainerFactory();
        container.setConnectionFactory(getActiveMqConnectionFactory());
        container.setAutoStartup(true);

        return container;
    }
}
