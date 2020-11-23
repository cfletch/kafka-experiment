package com.kafkatest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class MyConsumer {

    private static final Logger LOG = LoggerFactory.getLogger(MyConsumer.class);

    @KafkaListener(topics = "${app.topic.trades}", groupId = "t1")
    public void listen(@Payload String message) {
        LOG.info("received message='{}'", message);
    }

//    @KafkaListener(topics = "output", groupId = "o1")
//    public void listenToAggregate(@Payload String message) {
//        LOG.info("received message='{}'", message);
//    }
}