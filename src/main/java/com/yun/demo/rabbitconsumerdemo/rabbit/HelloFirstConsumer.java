package com.yun.demo.rabbitconsumerdemo.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class HelloFirstConsumer {

    @RabbitListener(queues = "hello")
    public void hello(String message) {
        System.out.println(message);
    }

}
