package org.example;
/**
 * 概念：
 * Producer：生产者。生产消息的一方。
 * Consumer：消费者。接收消息的一方。
 * Broker：消息中间件的服务节点。
 * Queue：队列。RabbitMQ的内部对象，用于存储消息。
 * Exchange：交换器。
 * RoutingKey：路由键。用于指定消息的路由规则。
 * Binding：绑定。RabbitMQ通过RoutingKey将交换机与队列进行绑定。
 */

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

/**
 * 消费者消费消息
 * 1、消费者连接到RabbitMQ Broker建立一个连接（Connection）并开启一个信道（Channel）
 * 2、消费者向RabbitMQ Broker请求相应队列中的消息并设置相应的回调函数。
 * 3、等待RabbitMQ Broker回应并投递相应队列中的消息，消费者接收消息。
 * 4、消费者确认接收到的消息。
 * 5、RabbitMQ删除队列中已经被确认的消息。
 * 6、关闭信道。
 * 7、关闭连接。
 */

/**
 * TTL
 *
 */