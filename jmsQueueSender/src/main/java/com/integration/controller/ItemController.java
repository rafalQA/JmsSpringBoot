package com.integration.controller;

import com.integration.jmsClient.JmsClient;
import com.integration.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Rafal Piotrowicz on 25.02.2017.
 */

@RestController
public class ItemController {

    private JmsClient jmsClient;

    @Autowired
    public ItemController(JmsClient jmsClient){
        this.jmsClient = jmsClient;
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/items")
    @ResponseStatus(value = HttpStatus.OK)
    public void sendItemToMessageBroker(@RequestBody Item item) {
        jmsClient.sendItem(item);
    }
}
