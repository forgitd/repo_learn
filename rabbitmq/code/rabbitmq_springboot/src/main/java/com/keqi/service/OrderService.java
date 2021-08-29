package com.keqi.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    /**
     * @Description 模式用户下单
     * @param userid
     * @param productid
     * @param num
     */
    public void makeOrder(String userid, String productid, int num) {
        // 1. 根据商品id判断库存是否充足
        // 2. 保存订单
        String orderId = UUID.randomUUID().toString();
        System.out.println("订单生成成功:" + orderId);
        // 3. 通过MQ来完成消息的分发
        // 参数一： 交换机， 参数二：路由key/queue队列名称 参数三：消息内容
        String exchange = "fanout_order_exchange";
        String routing_key = "";
        rabbitTemplate.convertAndSend(exchange, routing_key, orderId);

    }

    public void makeOrderDirect(String userid, String productid, int num) {
        // 1. 根据商品id判断库存是否充足
        // 2. 保存订单
        String orderId = UUID.randomUUID().toString();
        System.out.println("订单生成成功:" + orderId);
        // 3. 通过MQ来完成消息的分发
        // 参数一： 交换机， 参数二：路由key/queue队列名称 参数三：消息内容
        String exchange = "direct_order_exchange";
//        String routing_key = "";
        rabbitTemplate.convertAndSend(exchange, "email", orderId);
        rabbitTemplate.convertAndSend(exchange, "sms", orderId);

    }

    public void makeOrderTopic(String userid, String productid, int num) {
        // 1. 根据商品id判断库存是否充足
        // 2. 保存订单
        String orderId = UUID.randomUUID().toString();
        System.out.println("订单生成成功:" + orderId);
        // 3. 通过MQ来完成消息的分发
        // 参数一： 交换机， 参数二：路由key/queue队列名称 参数三：消息内容
        String exchange = "topic_order_exchange";
//        String routing_key = "";
        rabbitTemplate.convertAndSend(exchange, "email.sms.duanxin", orderId);

    }
}
