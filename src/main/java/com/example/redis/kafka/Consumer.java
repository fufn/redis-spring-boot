package com.example.redis.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class Consumer {
    @KafkaListener(id = "demoGroup", topics = "kafka")
    public void listen(String message) {
        log.info("Received: " + message);
    }
}
