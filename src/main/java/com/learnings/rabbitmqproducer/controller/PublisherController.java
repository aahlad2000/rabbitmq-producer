package com.learnings.rabbitmqproducer.controller;


import com.learnings.rabbitmqproducer.config.MessagingQueueConfig;
import com.learnings.rabbitmqproducer.model.MessageModel;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.UUID;

@RestController
public class PublisherController {

    @Autowired
    private RabbitTemplate template;

    @PostMapping("/publish")
    public String publishMessage(@RequestBody MessageModel message){
        message.setMessage(UUID.randomUUID().toString());
        message.setMessageDate(new Date());
        template.convertAndSend(MessagingQueueConfig.EXCHANGE,
                MessagingQueueConfig.ROUTING_KEY, message);
        return "Message Published";
    }

}
