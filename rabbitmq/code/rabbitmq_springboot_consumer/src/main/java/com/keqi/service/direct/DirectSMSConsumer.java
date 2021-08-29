package com.keqi.service.direct;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@RabbitListener(queues = {"sms.direct.queue"})
@Service
public class DirectSMSConsumer {

    @RabbitHandler
    public void reciveMessage(String msg) {
        System.out.println("接收到消息：" + msg);
    }
}
