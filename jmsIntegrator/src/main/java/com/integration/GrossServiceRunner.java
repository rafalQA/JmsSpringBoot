package com.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by Rafal Piotrowicz on 25.02.2017.
 */

@SpringBootApplication
@ImportResource("classpath:spring/META-INF/jmsIntegration.xml")
public class GrossServiceRunner {


    @Bean
    public ObjectMapper getObjectMapper(){
        return new ObjectMapper();
    }

    public static void main(String[] args) {
        SpringApplication.run(GrossServiceRunner.class, args);
    }
}
