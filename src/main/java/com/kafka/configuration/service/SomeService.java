package com.kafka.configuration.service;

import com.kafka.configuration.producer.Item;

public interface SomeService {

    Item addTimestamp(Item item);
}
