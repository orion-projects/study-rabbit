package org.example.basic;

import com.rabbitmq.client.Consumer;

import java.util.Map;

/**
 * RabbitMQ的消费模式分为：推（Push）模式和拉（Pull）模式。
 * 推模式通过订阅的方式来消费消息。接收消息一般通过实现Consumer接口或者继承DefaultConsumer类来实现。当调用与Consumer相关的API方法时，不同
 * 的订阅采用不同的消费者标签（consumerTag）来区分彼此，同一个Channel中的消费者也需要通过唯一的消费者标签以作区分。
 */
public class StudySubscribe {

    /**
     * 推模式消费消息。
     * @param queue 队列名称。
     * @param autoAck 是否自动确认。
     * @param consumerTag 消费者标签，用来区分多个消费者。
     * @param noLocal 是否不能将同一个Connection中生产者发送的消息传给这个消费者。
     * @param exclusive 是否排他。
     * @param arguments 消费者其他参数。
     * @param callback 回调函数。
     */
    public static void basicConsume(String queue, boolean autoAck, String consumerTag, boolean noLocal, boolean exclusive, Map<String, Object> arguments, Consumer callback){
        var channel = StudyChannel.getInstance();
        try{
            channel.basicConsume(queue, autoAck, consumerTag, noLocal, exclusive, arguments, callback);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 拉模式消费消息。
     * @param queue 队列名称。
     * @param autoAck 是否自动确认。
     */
    public static void basicGet(String queue, boolean autoAck){
        var channel = StudyChannel.getInstance();
        try {
            var response = channel.basicGet(queue, autoAck);
            System.out.println(new String(response.getBody()));
            if(!autoAck){
                channel.basicAck(response.getEnvelope().getDeliveryTag(), false);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }



}
