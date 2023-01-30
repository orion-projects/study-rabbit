package org.example.basic;

import java.util.Map;

public class StudyBind {
    /**
     * 将队列与交换机绑定。
     * @param queue 队列名字。
     * @param exchange 交换机名字。
     * @param routingKey RoutingKey。
     * @param arguments 一些参数。
     */
    public static void queueBind(String queue, String exchange, String routingKey, Map<String, Object> arguments){
        var channel = StudyChannel.getInstance();
        try {
            channel.queueBind(queue, exchange, routingKey, arguments);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 将队列与交换机绑定，在绑定完成之前返回。
     * @param queue
     * @param exchange
     * @param routingKey
     * @param arguments
     */
    public static void queueBindNoWait(String queue, String exchange, String routingKey, Map<String, Object> arguments){
        var channel = StudyChannel.getInstance();
        try {
            channel.queueBindNoWait(queue, exchange, routingKey, arguments);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 将队列与交换机进行解绑。
     * @param queue 队列名称。
     * @param exchange 交换机名字。
     * @param routingKey RoutingKey。
     * @param arguments 一些参数。
     */
    public static void queueUnbind(String queue, String exchange, String routingKey, Map<String, Object> arguments){
        var channel = StudyChannel.getInstance();
        try {
            channel.queueUnbind(queue, exchange, routingKey, arguments);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 将交换机与交换机进行绑定。
     * @param destination
     * @param source
     * @param routingKey
     * @param arguments
     */
    public static void exchangeBind(String destination, String source, String routingKey, Map<String, Object> arguments){
        var channel = StudyChannel.getInstance();
        try {
            channel.exchangeBind(destination, source, routingKey, arguments);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 将交换机与交换机进行绑定，绑定完成前返回。
     * @param destination
     * @param source
     * @param routingKey
     * @param arguments
     */
    public static void exchangeBindNoWait(String destination, String source, String routingKey, Map<String, Object> arguments){
        var channel = StudyChannel.getInstance();
        try {
            channel.exchangeBindNoWait(destination, source, routingKey, arguments);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void exchangeUnbind(String destination, String source, String routingKey, Map<String, Object> arguments){
        var channel = StudyChannel.getInstance();
        try {
            channel.exchangeUnbind(destination, source, routingKey, arguments);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
