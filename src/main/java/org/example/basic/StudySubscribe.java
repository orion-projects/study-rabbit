package org.example.basic;

import com.rabbitmq.client.Consumer;

import java.util.Map;

/**
 *      RabbitMQ的消费模式分为：推（Push）模式和拉（Pull）模式。
 *      推模式通过订阅的方式来消费消息。接收消息一般通过实现Consumer接口或者继承DefaultConsumer类来实现。当调用与Consumer相关的API方法时，不同
 * 的订阅采用不同的消费者标签（consumerTag）来区分彼此，同一个Channel中的消费者也需要通过唯一的消费者标签以作区分。
 *      消费者在订阅队列时可以指定autoAck参数，当autoAck等于false时，RabbitMQ会等待消费者显式地回复确认信号后才从内存或者磁盘中移去消息（实质上
 * 是先打删除标记之后删除）。当autoAck等于true时，RabbitMQ会自动把发送的消息置为确认，然后从内存或磁盘删除，而不管消费者是否真正地消费了这些
 * 消息。
 *      当autoAck参数置为false，对于RabbitMQ服务端而言，队列中的消息分成了两部分：一部分是等待投递给消费者的消息；一部分是已经投递给消费者但
 * 没有收到消费者确认的消息。
 *      RabbitMQ不会为未确认的消费者设置过期时间。判断消息是否需要重新投递给消费者的唯一依据是消费该消息的消费者连接是否已经断开。
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

    /**
     * 拒绝单条消息。
     * @param deliveryTag 消息编号。
     * @param requeue true：重新将消息存入队列以便发送给下一个订阅的消费者。
     *                false：将消息从队列中删除，不会发送给新的消费者。
     */
    public static void basicReject(long deliveryTag, boolean requeue){
        var channel = StudyChannel.getInstance();
        try {
            channel.basicReject(deliveryTag, requeue);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 批量拒绝消息。
     * @param deliveryTag 消息编号。
     * @param multiple true：拒绝deliveryTag编号之前所有未被当前消费者确认的消息。
     *                 false：拒绝编号为deliveryTag的消息。
     * @param requeue true：重新将消息存入队列以便发送给下一个订阅的消费者。
     *                false：将消息从队列中删除，不会发送给新的消费者。
     */
    public static void basicNack(long deliveryTag, boolean multiple, boolean requeue){
        var channel = StudyChannel.getInstance();
        try {
            channel.basicNack(deliveryTag, multiple, requeue);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 请求RabbitMQ重新发送未被确认的消息，相当于basicRecover(true)。
     */
    public static void basicRecover(){
        var channel = StudyChannel.getInstance();
        try {
            channel.basicRecover();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 请求RabbitMQ重新发送未被确认的消息。
     * @param requeue true：同一天消息可能会被分配给之前不同的消费者。
     *                false：同一条消息会被分配给与之前相同的消费者。
     */
    public static void basicRecover(boolean requeue){
        var channel = StudyChannel.getInstance();
        try {
            channel.basicRecover(requeue);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
