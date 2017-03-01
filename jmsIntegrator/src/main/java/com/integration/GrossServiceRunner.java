package com.integration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by Rafal Piotrowicz on 25.02.2017.
 */

@SpringBootApplication
@ImportResource("classpath:spring/META-INF/jmsIntegration.xml")
public class GrossServiceRunner {

    public static void main(String[] args) {
        SpringApplication.run(GrossServiceRunner.class, args);
    }
}
