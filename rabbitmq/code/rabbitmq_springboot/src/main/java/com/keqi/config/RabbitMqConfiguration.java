package com.keqi.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfiguration {

    // 1: 声明注册fanout模式的交换机
    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanout_order_exchange",true,false);
    }
    // 2: 声明注册sms.fanout.queue队列 duanxin email
    @Bean
    public Queue smsQueue() {
        return new Queue("sms.fanout.queue",true);
    }
    @Bean
    public Queue duanxinQueue() {
        return new Queue("duanxin.fanout.queue",true);
    }
    @Bean
    public Queue emailQueue() {
        return new Queue("email.fanout.queue",true);
    }
    // 3: 配置binding
    @Bean
    public Binding directSmsBinding() {
        return BindingBuilder.bind(smsQueue()).to(fanoutExchange());
    }
    @Bean
    public Binding directDuanxinBinding() {
        return BindingBuilder.bind(duanxinQueue()).to(fanoutExchange());
    }
    @Bean
    public Binding directEmailBinding() {
        return BindingBuilder.bind(emailQueue()).to(fanoutExchange());
    }
}
