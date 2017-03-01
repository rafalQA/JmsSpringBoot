package com.integration.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.integration.model.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * Created by rpiotrowicz on 2017-03-01.
 */

@Service
public class ItemGross {

    private static final Logger logger = LoggerFactory.getLogger(ItemGross.class);


    private Item item;
    private BigDecimal taxRatio;


    public ItemGross(){
        this.taxRatio = new BigDecimal("0.18");
    }

    public void makeItemPriceGross(String itemText){

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            this.item = objectMapper.readValue(itemText, Item.class);
        } catch (IOException e) {
            logger.warn("Can't convert to Item message {}", itemText);
        }

        BigDecimal taxValue = item.getPrice().multiply(taxRatio);

        BigDecimal grossPrice = item.getPrice().add(taxValue);

        item.setPrice(grossPrice);

        System.out.println(item.getPrice()
        );
    }

}
