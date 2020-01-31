package com.kafka.configuration.controller;

import com.kafka.configuration.consumer.Listener;
import com.kafka.configuration.producer.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

    private static final Logger logger =
            LoggerFactory.getLogger(KafkaController.class);

    @Autowired
    private KafkaTemplate<String, Item> template;

    @GetMapping("/msgs")
    public Item sendInformation() throws Exception {

        return Listener.LAST_ITEM;

    }
}
