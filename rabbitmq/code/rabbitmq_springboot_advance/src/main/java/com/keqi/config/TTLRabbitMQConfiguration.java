package com.keqi.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

@Configuration
public class TTLRabbitMQConfiguration {

    @Bean
    public DirectExchange ttlDirectExchange() {
        return new DirectExchange("ttl_exchange",true,false);
    }

    @Bean
    public Queue ttlQueue() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("x-message-ttl", 6000);   // 这里的参数是int类型，单位ms
        return new Queue("ttl_queue",true, false,false, map);
    }

    @Bean
    public Queue ttlMessageQueue() {
        return new Queue("ttl_message_queue");
    }

    @Bean
    public Queue ttlQueue_d() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("x-message-ttl", 6000);   // 这里的参数是int类型，单位ms
        map.put("x-dead-letter-exchange", "dead_exchange");
        map.put("x-dead-letter-routing-key", "dead");
        return new Queue("ttl_queue_dead",true, false,false, map);
    }

    @Bean
    public Binding ttlBinding() {
        return BindingBuilder.bind(ttlQueue()).to(ttlDirectExchange()).with("ttl");
    }

    @Bean
    public Binding ttlMessageBinding() {
        return BindingBuilder.bind(ttlMessageQueue()).to(ttlDirectExchange()).with("ttl_message");
    }

    @Bean
    public Binding ttlBinding_d() {
        return BindingBuilder.bind(ttlQueue_d()).to(ttlDirectExchange()).with("ttl_d");
    }
}
