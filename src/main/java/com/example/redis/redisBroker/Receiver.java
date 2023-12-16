package com.example.redis.redisBroker;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class Receiver implements MessageListener {
    private AtomicInteger counter = new AtomicInteger();

    public void receiveMessage(String message) {
        log.info("HERE");
    }

    public int getCount() {
        return counter.get();
    }

    @Override
    public void onMessage(Message message, byte[] pattern) {
        log.info("Received <" + message + ">");
        counter.incrementAndGet();
    }
}