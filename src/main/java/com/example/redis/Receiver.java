package com.example.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

import java.util.concurrent.atomic.AtomicInteger;

public class Receiver implements MessageListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);

    private AtomicInteger counter = new AtomicInteger();

    public void receiveMessage(String message) {
        LOGGER.info("HERE");
    }

    public int getCount() {
        return counter.get();
    }

    @Override
    public void onMessage(Message message, byte[] pattern) {
        LOGGER.info("Received <" + message + ">");
        counter.incrementAndGet();
    }
}