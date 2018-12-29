package com.yun.demo.rabbitconsumerdemo.rabbit;

import org.springframework.messaging.simp.SimpMessagingTemplate;

import javax.annotation.Resource;

public class GlobalConsumer {
    @Resource
    private static SimpMessagingTemplate simpMessagingTemplate;

    public static void hello(String message, String title) {
        String print = title + message;
        simpMessagingTemplate.convertAndSend("/topic/receiveHello", print);
        System.out.println(print);
    }
}
