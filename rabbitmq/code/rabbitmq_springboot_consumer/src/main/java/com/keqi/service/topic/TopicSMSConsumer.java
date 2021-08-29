package com.keqi.service.topic;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Service;

@Service
@RabbitListener(bindings = @QueueBinding(
        value = @Queue(value = "sms.topic.queue", durable = "true", autoDelete = "false"),
        exchange = @Exchange(value = "topic_order_exchange", type = ExchangeTypes.TOPIC),
        key = "#.sms.#"
))
public class TopicSMSConsumer {

    @RabbitHandler
    public void reviceMessage(String message) {
        System.out.println("接收到了消息：" + message);
    }
}