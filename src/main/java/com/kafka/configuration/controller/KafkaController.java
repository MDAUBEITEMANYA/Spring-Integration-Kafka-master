package com.kafka.configuration.controller;

import com.kafka.configuration.producer.Item;
import com.kafka.configuration.service.SomeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {
    @Autowired
    SomeServiceImpl someService;

    @GetMapping("/msgs")
    public Item sendInformation(){
        return someService.getSaveItem();
    }
}
