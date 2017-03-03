package com.integration.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.integration.model.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * Created by rpiotrowicz on 2017-03-01.
 */

@Service
public class ItemGross {

    private static final Logger logger = LoggerFactory.getLogger(ItemGross.class);

    private BigDecimal taxRatio;
    private ObjectMapper mapper;

    @Autowired
    public ItemGross(ObjectMapper mapper){
        this.taxRatio = new BigDecimal("0.18");
        this.mapper = mapper;
    }

    public Item makeItemPriceGross(String itemText){
        Item item = convertJsonTextToItem(itemText);
        setItemGrossPrice(item);

        return item;
    }

    private void setItemGrossPrice(Item item) {
        BigDecimal grossPrice = calculateAndGetGrossPrice(item);
        item.setPrice(grossPrice);
    }

    private BigDecimal calculateAndGetGrossPrice(Item item) {
        BigDecimal taxValue = item.getPrice().multiply(taxRatio);

        return item.getPrice().add(taxValue);
    }

    private Item convertJsonTextToItem(String itemText) {
        Item tempItem = null;

        try {
            tempItem = mapper.readValue(itemText, Item.class);
        } catch (IOException e) {
            logger.warn("Can't convert to Item message {}", itemText);
        }

        return tempItem;
    }
}
