package com.kafka.configuration.service;

import com.kafka.configuration.producer.Item;
import org.springframework.stereotype.Component;

@Component
public class SomeServiceImpl implements SomeService {
    private Item saveItem;

    public Item getSaveItem() {
        return saveItem;
    }

    @Override
    public Item addTimestamp(Item item) {
        item.setTimestamp(System.currentTimeMillis());
        System.out.println(item.toString());
        saveItem = item;
        return item;
    }

}
