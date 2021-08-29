package com.keqi.mq.work.fair;

// simple 简单模式
// 生产者 -->  消息队列 --> 消费者

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Producer {
    public static void main(String[] args) {
        // 所有的中间件都是基于tcp/ip协议的基础上构建的，只不过rabbitmq是rmqp协议
        // 离不开ip port

        // 1.创建连接工程
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("1.116.141.79");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("Admin97.");
        connectionFactory.setVirtualHost("/");

        Connection connection = null;
        Channel channel = null;
        try {
            // 2.创建连接Connection
            connection = connectionFactory.newConnection("生产者");
            // 3.通过连接获取通道Channel
            channel = connection.createChannel();
            // 4.通过通道创建交换机、声明队列、绑定关系、路由key、发送消息和接收消息

            String queueName = "queue1";
            /*
             * @param1 队列的名称
             * @param2 是否要持久化
             * @param3 排他性，是否是独占独立
             * @param4 是否自动删除，随着最后一个消费者消息完毕消息以后是否把队列自动删除
             * @param5 携带附属参数
             */
            channel.queueDeclare(queueName,true,false,false,null);
            // 5.准备消息内容
            for (int i = 0; i < 20; i++) {
                String msg = "keqi coming " + i;
                // 6.发送消息给队列queue
                channel.basicPublish("",queueName,null,msg.getBytes());
            }


            System.out.println("消息发送成功");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 7.关闭通道
            if (channel != null && channel.isOpen()) {
                try {
                    channel.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            // 8.关闭连接
            if (connection != null && connection.isOpen()) {
                try {
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
