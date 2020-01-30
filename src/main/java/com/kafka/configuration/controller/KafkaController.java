package com.kafka.configuration.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

    private static final Logger logger =
            LoggerFactory.getLogger(KafkaController.class);

    @GetMapping("/hello")
    public String hello() throws Exception {
        return "something";
    }
}
