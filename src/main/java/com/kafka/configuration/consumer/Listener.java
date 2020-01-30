package com.kafka.configuration.consumer;

import com.kafka.configuration.producer.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;


@Component
public class Listener {

    @Value("${kafka.topic.test2}")
    private String testTopic;

    @Autowired
    private KafkaTemplate<String, Item> template;

    @KafkaListener(topics = "some", id = "tpd-loggers")
    public void consume(Item item) {
        System.out.println("Consumed Message :" + item);
        template.send(testTopic, 0, System.currentTimeMillis(), String.valueOf(1), item);
    }
}
