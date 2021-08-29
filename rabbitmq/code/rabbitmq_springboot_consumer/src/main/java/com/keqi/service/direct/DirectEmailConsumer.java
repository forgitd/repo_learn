package com.keqi.service.direct;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RabbitListener(queues = {"email.direct.queue"})
public class DirectEmailConsumer {

    @RabbitHandler
    public void reviceMessage(String message) {
        System.out.println("接收到了消息：" + message);
    }
}