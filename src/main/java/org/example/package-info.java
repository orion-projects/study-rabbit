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
 * 消息的TTL
 * 1、通过队列的x-message-ttl属性为队列中所有消息设置过期时间。
 * 2、通过消息的expiration属性为消息单独设置过期时间。
 * 如果两种方法一起使用，则消息的TTL以两者之间较小的数值为准。消息在队列中的生存时间一旦超过设置的TTL值时就会变成死信。
 * 如果不设置TTL，则表示此消息不会过期；如果将TTL设置为0，则表示除非可以直接将消息投递到消费者，否则该消息会被立即丢弃。
 * note：为队列设置TTL，消息一旦过期就会从队列中抹去。因为队列中已过期的消息肯定在队列头部，RabbitMQ只要定期从队头开始扫描是否有过期消息即可。
 * 为消息设置TTL，则在消费时判定是否过期，如果过期再进行删除即可。
 *
 * 队列的TTL
 *
 */

/**
 * 持久化
 * 1、交换机的持久化
 *    交换机的持久化通过声明时将durable参数设置为true实现。如果交换机不设置持久化，RabbitMQ服务重启后相关的交换机元数据会丢失，不过消息不会
 * 丢失。
 * 2、队列的持久化
 *    队列的持久化通过时将durable参数设置为true实现。如果队列不设置持久化，RabbitMQ服务重启后相关的队列数据和消息都会丢失。
 * 3、消息的持久化
 *    消息的持久化通过将消息的deliveryMode属性设置为2实现。
 *    设置队列和消息的持久化，当RabbitMQ服务重启后，消息依旧存在。单单设置队列持久化，重启之后消息会丢失；单单设置消息持久化，重启之后队列和消息均丢
 * 失。
 */

/**
 * 消息顺序性
 *    消费者消费到的消息和发送者发布的消息顺序是一致的。
 *
 */

/**
 * 消息传输保障
 * 最少一次
 *    消息绝不会丢失，但可能会重复。
 *    1、消息生产者开启事务机制或者publisher confirm机制。
 *    2、消息生产者使用mandatory参数或者备份交换机，确保消息能从交换机路由到队列中。
 *    3、消息和队列都进行持久化处理。
 *    4、消费者将autoAck设置为false。
 * 最多一次
 *    无需考虑任何问题，生产者随意发送，消费者随意消费，不过难以保证消息不会丢失。
 * 恰好一次
 *    无法保障。比如当消费者在消费完一条消息后向RabbitMQ发送确认Basic.Ack命令。此时网络断开造成RabbitMQ没有收到确认命令。在重新建立连接之后，消
 * 费者还是会重复消费这一消息。
 */