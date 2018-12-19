package com.yun.demo.rabbitconsumerdemo.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class HelloSecondConsumer {

    @RabbitListener(queues = "hello")
    public void hello(String message) {
        System.out.println("HelloSecondConsumer: " + message);
    }
}
