package org.example.basic;

import java.util.Map;

/**
 * RabbitMQ交换机类型有fanout、direct、topic、headers。
 * 1、fanout
 *      把所有发送到fanout交换器的消息路由到与该交换器绑定的队列中。
 * 2、direct
 *      把消息路由到BindingKey和RoutingKey完全匹配的队列中。
 * 3、topic
 *      把消息路由到BindingKey和RoutingKey相匹配的队列中。
 *      BindingKey和RoutingKey为一个点号“.”分隔的字符串(被点号“.”分隔开的每一段
 *      独立的字符串称为一个单词)。BindingKey中使用“*”和“#”进行模糊匹配，“*”用于
 *      匹配一个单词，“#”用于匹配零个或多个单词。
 * 4、headers
 *      headers交换机根据发送的消息内容中的headers属性进行匹配。
 */
public class StudyExchange {

    /**
     * 创建交换机
     * @param exchange 交换机名称
     * @param type 交换机类型
     * @param durable 是否持久化
     * @param autoDelete 是否自动删除。自动删除的前提是至少有一个队列或者交换机与此交换机绑定之后所有与这个交换机
     *                   绑定的队列或交换机都解绑。
     * @param internal 是否内置。内置的交换机客户端程序无法直接发送消息到此交换机，只能通过交换机到交换机的方式。
     * @param arguments 结构化参数。
     *                  1、alternate-exchange
     *                  备份交换机，value为备份交换机的名称。如果消息未找到匹配的队列则转发到备份交换机，消息被重新发送到备份交换机时RoutingKey
     *                  和生产者发送的路由键是一样的。
     *                  如果备份交换机和mandatory参数一起使用，那么mandatory参数无效。
     *
     */
    public static void exchangeDeclare(String exchange, String type, boolean durable, boolean autoDelete, boolean internal, Map<String, Object> arguments){
        var channel = StudyChannel.getInstance();
        try {
            channel.exchangeDeclare(exchange, type, durable, autoDelete, internal, arguments);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 创建交换机。exchangeDeclareNoWait不需要等待服务器创建完成就会返回。
     * @param exchange
     * @param type
     * @param durable
     * @param autoDelete
     * @param internal
     * @param arguments
     */
    public static void exchangeDeclareNoWait(String exchange, String type, boolean durable, boolean autoDelete, boolean internal, Map<String, Object> arguments){
        var channel = StudyChannel.getInstance();
        try {
            channel.exchangeDeclareNoWait(exchange, type, durable, autoDelete, internal, arguments);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 检测交换机是否存在。存在则正常返回，不存在则抛出异常并关闭channel。
     * @param name 交换机名称。
     */
    public static void exchangeDeclarePassive(String name){
        var channel = StudyChannel.getInstance();
        try {
            var result = channel.exchangeDeclarePassive(name);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 删除交换机。
     * @param exchange 交换机名字。
     * @param ifUnused 是否在交换机没有使用的情况下删除。
     */
    public static void exchangeDelete(String exchange, boolean ifUnused){
        var channel = StudyChannel.getInstance();
        try {
            channel.exchangeDelete(exchange, ifUnused);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 删除交换机。exchangeDeleteNoWait会在删除完成前返回。
     * @param exchange 交换机名称
     * @param ifUnused 是否在交换机没有使用的情况下删除。
     */
    public static void exchangeDeleteNoWait(String exchange, boolean ifUnused){
        var channel = StudyChannel.getInstance();
        try{
            channel.exchangeDeleteNoWait(exchange, ifUnused);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
