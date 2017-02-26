package com.integration.JmsClient;

import com.integration.model.Item;

import java.util.List;

/**
 * Created by Rafal Piotrowicz on 25.02.2017.
 */
public interface JmsClient {

    void sendItem(Object object);
    List<Item> getItems();
}
