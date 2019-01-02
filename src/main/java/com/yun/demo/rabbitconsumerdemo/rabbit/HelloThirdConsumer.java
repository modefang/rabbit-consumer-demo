package com.yun.demo.rabbitconsumerdemo.rabbit;

import com.yun.demo.rabbitconsumerdemo.Util.JsonUtil;
import rabbit.pojo.UserRabbitPojo;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class HelloThirdConsumer {
    private final String MESSAGE_TITLE = "#3 HelloThirdConsumer: ";

    @Resource
    private GlobalConsumer globalConsumer;

    @RabbitListener(queues = "hello")
    public void hello(String message) {
        message = this.MESSAGE_TITLE + message;
        globalConsumer.convertAndSend("/topic/receiveHello", message);
    }

    @RabbitListener(queues = "object")
    public void object(UserRabbitPojo user) {
        String message = this.MESSAGE_TITLE + user.getName() + " " + JsonUtil.objectToJson(user);
        globalConsumer.convertAndSend("/topic/receiveObject", message);
    }

    @RabbitListener(queues = "manyToMany")
    public void manyToMany(String message) {
        message = this.MESSAGE_TITLE + message;
        globalConsumer.convertAndSend("/topic/receiveManyToMany", message);
    }

}
