package jmsQueueSender.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Created by rpiotrowicz on 2017-02-28.
 */
@PropertySource(value = "classpath:application.properties")
@Import({ActiveMqConfiguration.class, ItemConfig.class, RestClientConfig.class})
public class DefaultConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }



}


