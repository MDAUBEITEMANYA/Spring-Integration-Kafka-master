package com.kafka.configuration.consumer;

import com.kafka.configuration.ConfigProperties;
import com.kafka.configuration.producer.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;


@Component
public class Listener {
    public static Item LAST_ITEM;
    @Autowired
    ConfigProperties configProperties;

    @Autowired
    private KafkaTemplate<String, Item> template;

    @KafkaListener(topics = "some11", id = "tpd-loggers")
    public void consume(Item item) {
        System.out.println("Consumed Message :" + item);
        LAST_ITEM = item;
        System.out.println(item.toString());
        template.send(configProperties.getTopic2(), 0, System.currentTimeMillis(), String.valueOf(1), item);
    }

}
