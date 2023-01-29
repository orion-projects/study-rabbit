package org.example.basic;

import java.util.Map;

/**
 *
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
     */
    public static void queueDeclare(String queue, boolean durable, boolean exclusive, boolean autoDelete, Map<String, Object> arguments){
        var channel = StudyChannel.getInstance();
        try {
            channel.queueDeclare(queue, durable, exclusive, autoDelete, arguments);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
