package jmsQueueSender.model;

import java.math.BigDecimal;

/**
 * Created by rpiotrowicz on 2017-02-27.
 */
public class Item {

    private String name;
    private BigDecimal price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
