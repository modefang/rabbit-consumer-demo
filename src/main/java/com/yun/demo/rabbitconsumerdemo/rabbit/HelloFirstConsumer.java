package com.yun.demo.rabbitconsumerdemo.rabbit;

import com.yun.demo.rabbitconsumerdemo.Util.JsonUtil;
import rabbit.pojo.UserRabbitPojo;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class HelloFirstConsumer {
    private final String MESSAGE_TITLE = "#1 HelloFirstConsumer: ";

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

    @RabbitListener(queues = "topic.message")
    public void topicMessage(String message) {
        message = this.MESSAGE_TITLE + message + " The receiver is topic.message.";
        globalConsumer.convertAndSend("/topic/receiveTopic", message);
    }

    @RabbitListener(queues = "topic.messages")
    public void topicMessages(String message) {
        message = this.MESSAGE_TITLE + message + " The receiver is topic.messages.";
        globalConsumer.convertAndSend("/topic/receiveTopic", message);
    }

    @RabbitListener(queues = "fanout.A")
    public void fanoutA(String message) {
        message = this.MESSAGE_TITLE + message + " The receiver is fanout.A.";
        globalConsumer.convertAndSend("/topic/receiveFanout", message);
    }

    @RabbitListener(queues = "fanout.B")
    public void fanoutB(String message) {
        message = this.MESSAGE_TITLE + message + " The receiver is fanout.B.";
        globalConsumer.convertAndSend("/topic/receiveFanout", message);
    }

    @RabbitListener(queues = "fanout.C")
    public void fanoutC(String message) {
        message = this.MESSAGE_TITLE + message + " The receiver is fanout.C.";
        globalConsumer.convertAndSend("/topic/receiveFanout", message);
    }

    @RabbitListener(queues = "topic.callback.message")
    public void topicCallback(String message) {
        message = this.MESSAGE_TITLE + message + " The receiver is topic.callback.message.";
        globalConsumer.convertAndSend("/topic/receiveCallback", message);
    }

}
