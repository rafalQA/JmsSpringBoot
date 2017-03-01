package com.integration.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.connection.SingleConnectionFactory;

import javax.jms.ConnectionFactory;

/**
 * Created by rpiotrowicz on 2017-03-01.
 */
@Configuration
public class ActiveMQConfig {


    @Bean
    public ConnectionFactory connection(){
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
        factory.setBrokerURL("tcp://localhost:61616");
        factory.setUserName("admin");
        factory.setPassword("admin");

        return new SingleConnectionFactory(factory);
    }

    @Bean
    public ActiveMQQueue queue(){
        return new ActiveMQQueue("DEMO-QUEUE");
    }
}
