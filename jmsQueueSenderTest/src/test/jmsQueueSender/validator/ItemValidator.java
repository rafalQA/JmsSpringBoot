package jmsQueueSender.validator;

import jmsQueueSender.model.Item;
import org.springframework.util.Assert;

import java.math.BigDecimal;

/**
 * Created by rpiotrowicz on 2017-02-28.
 */

public class ItemValidator  {

    public void validate(Item item) {
        Assert.notNull(item);
        Assert.notNull(item.getName());
        Assert.isTrue(!item.getName().isEmpty());
        Assert.notNull(item.getPrice());
        Assert.isTrue(item.getPrice().compareTo(BigDecimal.ZERO) == 1);
    }
}
