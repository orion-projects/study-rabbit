package org.example.basic;

import com.rabbitmq.client.AMQP;

public class StudyPublish {
    /**
     * 发送消息
     * @param exchange 消息发送到的交换机名称。如果为空则将消息发送带RabbitMQ默认的交换机中。
     * @param routingKey RoutingKey。交换机根据RoutingKey将消息存储到相应的队列中。
     * @param mandatory true：交换机无法根据自身的类型和路由键找到匹配的队列，那么RabbitMQ会将消息返回给生产者。
     *                  false：消息直接丢弃。
     *                  生产者通过channel.addReturnListener添加ReturnerListener监听器获取未被路由的消息。
     * @param immediate true：交换机在将消息路由到队列时发现队列上并没有任何消费者时，RabbitMQ会将消息返回给生产者。
     *                  false：消息直接丢弃。
     *                  RabbitMQ 3.0版本开始去掉对该参数的支持，建议采用TTL和DLX的方法替代。
     * @param props 消息的属性。
     *              1、contentType
     *              2、contentEncoding
     *              3、headers
     *              4、deliveryMode
     *              5、priority
     *              6、correlationId
     *              7、replyTo
     *              8、expiration
     *                  过期时间，单位毫秒。
     *              9、messageId
     *              10、timestamp
     *              11、type
     *              12、userId
     *              13、appId
     *              14、clusterId
     *              {@link com.rabbitmq.client.MessageProperties}
     *              {@link AMQP.BasicProperties.Builder}
     * @param body 消息体。
     */
    public static void basicPublish(String exchange, String routingKey, boolean mandatory, boolean immediate, AMQP.BasicProperties props, byte[] body){
        var channel = StudyChannel.getInstance();
        try {
            channel.basicPublish(exchange, routingKey, mandatory, immediate, props, body);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
