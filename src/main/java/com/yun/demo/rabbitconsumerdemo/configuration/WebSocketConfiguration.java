package com.yun.demo.rabbitconsumerdemo.configuration;

import com.yun.demo.rabbitconsumerdemo.constant.ResponseEnum;
import com.yun.demo.rabbitconsumerdemo.pojo.ResponseMessage;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

import javax.annotation.Resource;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfiguration implements WebSocketMessageBrokerConfigurer {

    @Resource
    private SimpMessagingTemplate simpMessagingTemplate;

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/websocket").setAllowedOrigins("*").withSockJS();
    }

    @MessageExceptionHandler
    public ResponseMessage handleException(Throwable exception) {
        simpMessagingTemplate.convertAndSend("/websocket/error", exception.getMessage());
        return new ResponseMessage(ResponseEnum.ERROR, -1);
    }

}
