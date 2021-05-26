package com.anvesh.springjms.sender;


import com.anvesh.springjms.config.JmsConfig;
import com.anvesh.springjms.model.HelloWorldMessage;
import lombok.AllArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
public class HelloSender {
    private final JmsTemplate template;

    @Scheduled(fixedRate = 3000)
    public void sendMessage() {
        System.out.println("Sending a message....");
        HelloWorldMessage message = HelloWorldMessage
                .builder().id(UUID.randomUUID())
                .message("Hello world").build();
        template.convertAndSend(JmsConfig.my_Queue, message);
        System.out.println("Message Sent");

    }
}
