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
    @Value("${item.inputPrice}")
    private BigDecimal itemInputPrice;
    @Value("${item.expectedPrice}")
    private BigDecimal itemExpectedPrice;

    @Bean
    @Qualifier("input")
    public Item getInputItem() {
        Item item = new Item();
        item.setName(itemName);
        item.setPrice(itemInputPrice);

        return item;
    }

    @Bean
    @Qualifier("expected")
    public Item getExpectedItem() {
        Item item = new Item();
        item.setName(itemName);
        item.setPrice(itemExpectedPrice);

        return item;
    }

    @Bean
    public ItemValidator getItemValidator(){
        return new ItemValidator();
    }
}
