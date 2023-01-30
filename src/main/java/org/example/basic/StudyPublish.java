package org.example.basic;

import com.rabbitmq.client.AMQP;

public class StudyPublish {
    /**
     * 发送消息
     * @param exchange 消息发送到的交换机名称。如果为空则将消息发送带RabbitMQ默认的交换机中。
     * @param routingKey RoutingKey。交换机根据RoutingKey将消息存储到相应的队列中。
     * @param mandatory
     * @param immediate
     * @param props 消息的属性。
     *              1、contentType
     *              2、contentEncoding
     *              3、headers
     *              4、deliveryMode
     *              5、priority
     *              6、correlationId
     *              7、replyTo
     *              8、expiration
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
