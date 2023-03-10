package org.example.basic;

import java.util.Map;

/**
 * 生产者和消费者都可以声明队列。如果消费者在同一个信道上订阅了另一个队列就无
 * 法再声明队列。必须先取消订阅，然后将信道置为传输模式之后才能声明队列。
 */
public class StudyQueue {

    /**
     * 创建队列
     * @param queue 队列名称。
     * @param durable 是否持久化。
     * @param exclusive 是否排他。排他队列仅对首次声明它的连接可见并在连接断开时自动删除。
     *                  1、排他队列是基于连接可见的，同一连接的不同信道可以同时访问同一连接
     *                  创建的排他队列。
     *                  2、首次是指如果一个连接已经声明了一个排他队列其他连接是不允许创建同
     *                  名的排他队列。
     *                  3、排他队列即使是持久化的也会在连接关闭或者客户端关闭时自动删除。
     * @param autoDelete 是否自动删除。至少有一个消费者连接这个队列之后所有与这个队列连接的
     *                   消费者都断开时才会自动删除。
     * @param arguments 队列的一些参数。
     *                  1、x-message-ttl
     *                      设置消息的TTL（过期时间），单位是毫秒。
     *                  2、x-expires
     *                      设置队列的TTL（过期时间），单位毫秒。如果队列再指定的时间未被使用就会被删除。
     *                      未使用是指队列没有任何消费者、队列没有被重新声明并且在过期时间段内也未调用过Basic.Get命令。
     *                  3、x-max-length
     *                      设置队列可以容纳的消息最大条数，超过这个条数队列头部的消息将会被丢弃。
     *                  4、x-max-length-bytes
     *                      设置队列可以容纳的消息的最大字节数，超过这个字节数队列头部的消息将会被丢弃。
     *                  5、x-dead-letter-exchange
     *                      设置队列的死信交换机。
     *                  6、x-dead-letter-routing-key
     *                      设置死信的RoutingKey，如果没有指定，则使用原RoutingKey。
     *                  7、x-max-priority
     *                      设置队列中消息的优先级最大值。如果没有设置该参数，那么该队列不支持消息优先级功能。
     *                      如果消费者的消费速度大于生产者的速度且Broker中没有消息堆积的情况下，对发送的消息设置优先级没有实际意义。
     *                  8、x-overflow
     *                      设置队列消息溢出时，如何处理这些消息。
     *                      1、drop-head：丢弃队列头部的消息，默认值。
     *                      2、reject-publish：拒绝接收生产者发送过来的所有消息。
     *                  9、x-queue-mode
     *
     */
    public static void queueDeclare(String queue, boolean durable, boolean exclusive, boolean autoDelete, Map<String, Object> arguments){
        var channel = StudyChannel.getInstance();
        try {
            channel.queueDeclare(queue, durable, exclusive, autoDelete, arguments);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 创建队列。在队列创建完成前返回。
     * @param queue
     * @param durable
     * @param exclusive
     * @param autoDelete
     * @param arguments
     */
    public static void queueDeclareNoWait(String queue, boolean durable, boolean exclusive, boolean autoDelete, Map<String, Object> arguments){
        var channel = StudyChannel.getInstance();
        try {
            channel.queueDeclareNoWait(queue, durable, exclusive, autoDelete, arguments);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 检测队列是否存在。如果存在则正常返回，不存在则抛出异常。
     * @param queue 队列名称。
     */
    public static void queueDeclarePassive(String queue){
        var channel = StudyChannel.getInstance();
        try {
            channel.queueDeclarePassive(queue);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 删除队列。
     * @param queue 队列名称。
     * @param ifUnused 是否正在使用。
     * @param ifEmpty 是否为空。
     */
    public static void queueDelete(String queue, boolean ifUnused, boolean ifEmpty){
        var channel = StudyChannel.getInstance();
        try {
            channel.queueDelete(queue, ifUnused, ifEmpty);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 删除队列，删除完成前返回。
     * @param queue 队列名称。
     * @param ifUnused 是否正在使用。
     * @param ifEmpty 是否为空。
     */
    public static void queueDeleteNoWait(String queue, boolean ifUnused, boolean ifEmpty){
        var channel = StudyChannel.getInstance();
        try {
            channel.queueDeleteNoWait(queue, ifUnused, ifEmpty);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 清空队列中的内容。
     * @param queue 队列名称。
     */
    public static void queuePurge(String queue){
        var channel = StudyChannel.getInstance();
        try {
            channel.queuePurge(queue);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
