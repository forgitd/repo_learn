package com.keqi.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DirectRabbitMQConfiguration {
    // 1: 声明注册fanout模式的交换机
    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange("direct_order_exchange",true,false);
    }
    // 2: 声明注册sms.direct.queue队列 duanxin email
    @Bean
    public Queue directSmsQueue() {
        return new Queue("sms.direct.queue",true);
    }
    @Bean
    public Queue directDuanxinQueue() {
        return new Queue("duanxin.direct.queue",true);
    }
    @Bean
    public Queue directEmailQueue() {
        return new Queue("email.direct.queue",true);
    }
    // 3: 配置binding
    @Bean
    public Binding smsBinding() {
        return BindingBuilder.bind(directSmsQueue()).to(directExchange()).with("sms");
    }
    @Bean
    public Binding duanxinBinding() {
        return BindingBuilder.bind(directDuanxinQueue()).to(directExchange()).with("duanxin");
    }
    @Bean
    public Binding emailBinding() {
        return BindingBuilder.bind(directEmailQueue()).to(directExchange()).with("email");
    }
}
