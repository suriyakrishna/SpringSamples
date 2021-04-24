package com.kishan.springpractice.controllers;

import com.kishan.springpractice.configs.MyKafkaConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
@Slf4j
@Profile("test")
public class KafkaPractiseController {
    private MyKafkaConfig myKafkaConfig;

    @Autowired
    public KafkaPractiseController(MyKafkaConfig myKafkaConfig) {
        this.myKafkaConfig = myKafkaConfig;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello Kafka";
    }

    @PostMapping("/send")
    public String send(@RequestParam(name = "key") String key,
                       @RequestParam(name = "message") String message) {
        log.info("Sending Message: " + "Key=" + key + " message=" + message);
        myKafkaConfig.sendMessage("hello-kafka", key, message);
        return "Message Sent Successfully: " + message;
    }
}
