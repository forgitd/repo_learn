package com.keqi.mq.direct;

import com.rabbitmq.client.*;

import java.io.IOException;

public class Consumer {

    private static Runnable runnable = new Runnable() {
        @Override
        public void run() {
            // 所有的中间件都是基于tcp/ip协议的基础上构建的，只不过rabbitmq是rmqp协议
            // 离不开ip port

            // 1.创建连接工程
            ConnectionFactory connectionFactory = new ConnectionFactory();
            connectionFactory.setHost("1.116.141.79");
            connectionFactory.setPort(5672);
            connectionFactory.setUsername("admin");
            connectionFactory.setPassword("Admin97.");
            connectionFactory.setVirtualHost("/");

            // 通过线程名获取队列名
            String queueName = Thread.currentThread().getName();
            Connection connection = null;
            Channel channel = null;
            try {
                // 2.创建连接Connection
                connection = connectionFactory.newConnection("生产者");
                // 3.通过连接获取通道Channel
                channel = connection.createChannel();
                // 4.通过通道创建交换机、声明队列、绑定关系、路由key、发送消息和接收消息

                System.out.println(channel.basicConsume(queueName, true, new DeliverCallback() {
                    @Override
                    public void handle(String consumerTag, Delivery message) throws IOException {
                        System.out.println("收到消息是：" + new String(message.getBody(), "UTF-8"));
                    }
                }, new CancelCallback() {
                    @Override
                    public void handle(String consumerTag) throws IOException {
                        System.out.println("接受消息失败...");
                    }
                }));

                System.out.println("开始接受消息");
                // 程序不往下执行，开始接收消息
                System.in.read();

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
    };


    public static void main(String[] args) {
        new Thread(runnable,"queue2").start();
        new Thread(runnable,"queue3").start();
    }
}
