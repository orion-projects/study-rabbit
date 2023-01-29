package org.example;

/**
 * rabbitMQ常用命令:
 * 1、rabbitmqctl status:检查rabbitMQ的状态。
 * 2、rabbitmq-server start:开启rabbitMQ。
 * 3、rabbitmq-server stop:关闭rabbitMQ。
 * 4、rabbitmq-server restart:重启rabbitMQ。
 * 5、rabbitmq-plugins enable rabbitmq_management:开启可视化管理插件。
 *
 * rabbitMQ常用端口号:
 * 1、5672:rabbitMQ服务端口号。
 * 2、15672:rabbitMQ可视化管理端口号。
 */

/**
 * 生产者发送消息:
 * 1、生产者连接到RabbitMQ Broker建立一个连接（Connection）并开启一个信道（Channel）。
 * 2、生产者声明一个交换器并设置相关属性。
 * 3、生产者声明一个队列并设置相关属性。
 * 4、生产者通过RoutingKey将交换器和队列绑定起来。
 * 5、生产者将消息发送至RabbitMQ Broker其中包含交换器、RoutingKey等信息。
 * 6、相应的交换器根据接收到的RoutingKey查找匹配的队列。
 * 7、如果找到则将生产者发送的消息存入相应的队列中。
 * 8、如果没有找到则根据生产者配置的属性选择丢弃或退回给生产者。
 * 9、关闭信道。
 * 10、关闭连接。
 */