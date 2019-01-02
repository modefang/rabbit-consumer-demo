package com.yun.demo.rabbitconsumerdemo.rabbit;

import org.springframework.messaging.simp.SimpMessagingTemplate;

import javax.annotation.Resource;

public class GlobalConsumer {

    @Resource
    private SimpMessagingTemplate simpMessagingTemplate;

    public void convertAndSend(String exchange, String message) {
        simpMessagingTemplate.convertAndSend(exchange, message);
        System.out.println(message);
    }

}
