package com.example.redis.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
@Slf4j
public class Producer {

    private final KafkaTemplate<Object, Object> kafkaTemplate;

    @Scheduled(fixedDelay = 2000)
    public void sendFoo() {
        log.info("producing message to Kafka, topic=kafka");
        this.kafkaTemplate.send("kafka", Instant.now().toString());
    }
}
