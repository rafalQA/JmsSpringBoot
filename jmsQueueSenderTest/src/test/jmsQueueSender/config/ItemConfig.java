package jmsQueueSender.config;

import jmsQueueSender.model.Item;
import jmsQueueSender.validator.ItemValidator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

/**
 * Created by rpiotrowicz on 2017-02-28.
 */
@Configuration
public class ItemConfig {

    @Value("${item.name}")
    private String itemName;
    @Value("${item.price}")
    private BigDecimal itemPrice;

    @Bean
    @Qualifier("input")
    public Item getItem() {
        Item item = new Item();
        item.setName(itemName);
        item.setPrice(itemPrice);

        return item;
    }

    @Bean
    public ItemValidator getItemValidator(){
        return new ItemValidator();
    }
}
