package com.yun.demo.rabbitconsumerdemo.rabbit;

import com.yun.demo.rabbitconsumerdemo.Util.JsonUtil;
import rabbit.pojo.UserRabbitPojo;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class HelloFirstConsumer {
    private final String MESSAGE_TITLE = "#1 HelloFirstConsumer: ";

    @RabbitListener(queues = "hello")
    public void hello(String message) {
        GlobalConsumer.hello(message, this.MESSAGE_TITLE);
    }

    @RabbitListener(queues = "object")
    public void object(UserRabbitPojo user) {
        System.out.println(this.MESSAGE_TITLE + user.getName() + " " + JsonUtil.objectToJson(user));
    }

    @RabbitListener(queues = "topic.message")
    public void topicMessage(String message) {
        System.out.println(this.MESSAGE_TITLE + message + " The receiver is topic.message.");
    }

    @RabbitListener(queues = "topic.messages")
    public void topicMessages(String message) {
        System.out.println(this.MESSAGE_TITLE + message + " The receiver is topic.messages.");
    }

    @RabbitListener(queues = "fanout.A")
    public void fanoutA(String message) {
        System.out.println(this.MESSAGE_TITLE + message + " The receiver is fanout.A.");
    }

    @RabbitListener(queues = "fanout.B")
    public void fanoutB(String message) {
        System.out.println(this.MESSAGE_TITLE + message + " The receiver is fanout.B.");
    }

    @RabbitListener(queues = "fanout.C")
    public void fanoutC(String message) {
        System.out.println(this.MESSAGE_TITLE + message + " The receiver is fanout.C.");
    }

}
