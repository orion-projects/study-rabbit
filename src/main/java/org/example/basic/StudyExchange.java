package org.example.basic;

import com.rabbitmq.client.AMQP;

import java.util.Map;

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
     */
    public void createExchange(String exchange, String type, boolean durable, boolean autoDelete, boolean internal, Map<String, Object> arguments){
        var channel = StudyChannel.getInstance();
        try {
            channel.exchangeDeclare(exchange, type, durable, autoDelete, internal, arguments);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 创建交换机。exchangeDeclareNoWait不需要等待服务器创建完成。
     * @param exchange
     * @param type
     * @param durable
     * @param autoDelete
     * @param internal
     * @param arguments
     */
    public void createExchangeNowait(String exchange, String type, boolean durable, boolean autoDelete, boolean internal, Map<String, Object> arguments){
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
    public void createExchangePassive(String name){
        var channel = StudyChannel.getInstance();
        try {
            channel.exchangeDeclarePassive(name);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void deleteExchange(String exchange, boolean ifUnused){

    }
}
