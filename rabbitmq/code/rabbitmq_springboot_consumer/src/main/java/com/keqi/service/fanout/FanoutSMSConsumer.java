package com.keqi.service.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@RabbitListener(queues = {"sms.fanout.queue"})
@Service
public class FanoutSMSConsumer {

    @RabbitHandler
    public void reciveMessage(String msg) {
        System.out.println("接收到消息：" + msg);
    }
}
