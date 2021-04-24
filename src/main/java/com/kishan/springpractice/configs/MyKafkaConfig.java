package com.kishan.springpractice.configs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Slf4j
@Component
@Profile("test")
public class MyKafkaConfig {
    private KafkaTemplate<String, String> kafkaTemplate;

    private CountDownLatch latch = new CountDownLatch(1);

    private String payload = null;

    @Autowired
    public MyKafkaConfig(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String topic, String key, String message) {
        log.info(String.format("Sending Message to topic=%s, key=%s, message=%s", topic, key, message));
        kafkaTemplate.send(topic, key, message);
    }

    @KafkaListener(topics = "hello-kafka")
    public void listenWithHeaders(
            @Payload String message,
            @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
            @Header(KafkaHeaders.OFFSET) long offset) {
        String msg = String.format("Message: %s. Partition: %d and Offset: %d", message, partition, offset);
        log.info("Received Message: " + message
                + " from partition: " + partition
                + " from offset: " + offset);
        latch.countDown();
        setPayload(msg);
        this.sendMessage("message-status", Long.toString(System.currentTimeMillis()), msg);
    }

    public CountDownLatch getLatch() {
        return latch;
    }

    public void setLatch(CountDownLatch latch) {
        this.latch = latch;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }
}
