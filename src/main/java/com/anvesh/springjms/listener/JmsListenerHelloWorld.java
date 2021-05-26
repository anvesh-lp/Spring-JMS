package com.anvesh.springjms.listener;

import com.anvesh.springjms.config.JmsConfig;
import com.anvesh.springjms.model.HelloWorldMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class JmsListenerHelloWorld {

    @JmsListener(destination = JmsConfig.my_Queue)
    public void listen(@Payload HelloWorldMessage helloWorldMessage, @Headers MessageHeaders headers, Message message) {
        System.out.println("Got the message.....!!!");
        System.out.println(helloWorldMessage);
    }

}
