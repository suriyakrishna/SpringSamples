package com.kishan.springpractice;

import com.kishan.springpractice.configs.MyKafkaConfig;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;


@ActiveProfiles("test")
@SpringBootTest
@DirtiesContext
@EmbeddedKafka(partitions = 1, brokerProperties = {"listeners=PLAINTEXT://localhost:9092", "port=9092"})
public class KafkaEmbeddedTest {

    @Autowired
    KafkaListenerEndpointRegistry kafkaListenerEndpointRegistry;

    @Autowired
    private MyKafkaConfig kafkaConfig;

    @Disabled
    @Test
    public void testSendMessage() throws InterruptedException {
        kafkaConfig.sendMessage("hello-kafka", "hello", "hello");
        kafkaConfig.getLatch().await(10, TimeUnit.SECONDS);
        assertThat(kafkaConfig.getLatch().getCount(), equalTo(0L));
        assertThat(kafkaConfig.getPayload(), is("Message: hello. Partition: 0 and Offset: 0"));

    }


}
