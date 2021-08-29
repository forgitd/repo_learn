package com.keqi.service;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TTLService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void ttl() {
        rabbitTemplate.convertAndSend("ttl_exchange", "ttl", "ttl_test");
    }

    public void ttl_message() {
        MessagePostProcessor messagePostProcessor = new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                message.getMessageProperties().setExpiration("3000");
                message.getMessageProperties().setContentEncoding("UTF-8");
                return message;
            }
        };

        rabbitTemplate.convertAndSend("ttl_exchange", "ttl_message", "ttl_test", messagePostProcessor);
    }

    public void ttl_d() {
        rabbitTemplate.convertAndSend("ttl_exchange", "ttl_d", "ttl_d_test");
    }

}
