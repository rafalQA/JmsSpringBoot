package com.integration.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.connection.SingleConnectionFactory;

import javax.jms.ConnectionFactory;

/**
 * Created by rpiotrowicz on 2017-03-01.
 */
@Configuration
public class
ActiveMQConfig {

    @Value("${activemq.broker-url}")
    private String brokerUrl;
    @Value("${activemq.user}")
    private String brokerUserName;
    @Value("${activemq.password}")
    private String brokerPassword;
    @Value("${active.inboundQueue}")
    private String inboundQueue;
    @Value("${active.outboundQueue}")
    private String outboundQueue;

    @Bean
    public ConnectionFactory connectionFactory(){
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
        factory.setBrokerURL(brokerUrl);
        factory.setUserName(brokerUserName);
        factory.setPassword(brokerPassword);

        return new SingleConnectionFactory(factory);
    }

    @Bean
    public ActiveMQQueue inboundQueue(){
        return new ActiveMQQueue(inboundQueue);
    }

    @Bean
    public ActiveMQQueue outboundQueue(){
        return new ActiveMQQueue(outboundQueue);
    }
}
