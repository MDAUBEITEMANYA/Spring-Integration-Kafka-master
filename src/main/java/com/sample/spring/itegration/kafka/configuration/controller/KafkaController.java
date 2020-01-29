package com.sample.spring.itegration.kafka.configuration.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@RestController
public class KafkaController {

   /* private final int messagesPerRequest;
    private static final Logger logger =
            LoggerFactory.getLogger(KafkaController.class);

    @GetMapping("/hello")
    public String hello() throws Exception {
        IntStream.range(0, messagesPerRequest)
                .forEach(i -> this.template.send(topicName, String.valueOf(i),
                        new PracticalAdvice("A Practical Advice", i))
                );
        logger.info("All messages received");
        return "Hello Kafka!";

    */
    }
