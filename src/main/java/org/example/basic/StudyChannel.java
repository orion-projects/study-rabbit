package org.example.basic;

import com.rabbitmq.client.Channel;

public class StudyChannel {
    private static Channel instance = null;

    private StudyChannel(){

    }

    synchronized public static Channel getInstance(){
        if(instance==null){
            instance = createChannel();
        }

        return instance;
    }

    /**
     * 创建信道。
     * @return 信道实例。
     */
    private static Channel createChannel(){
        try {
            return StudyConnection.getInstance().createChannel();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static void isOpen(){
        var channel = StudyChannel.getInstance();
        if(channel.isOpen()){
            System.out.println("信道打开状态！");
        }else {
            System.out.println("信道关闭状态！");
        }
    }

    /**
     * 获取关闭原因。
     */
    public static void getCloseReason(){
        var channel = StudyChannel.getInstance();
        System.out.println(channel.getCloseReason().getReason());
    }

    /**
     * 关闭信道。
     */
    public static void close(){
        if(instance!=null){
            try {
                instance.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    /**
     * 关闭信道。
     * @param closeCode
     * @param closeMessage
     */
    public static void close(int closeCode, String closeMessage){
        if(instance!=null){
            try {
                instance.close(closeCode, closeMessage);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    /**
     *
     */
    public static void addShutdownListener(){
        if(instance!=null){
            instance.addShutdownListener(cause -> {
                System.out.println("shout down RabbitMQ");
            });
        }
    }

    /**
     *
     */
    public static void removeShutdownListener(){
        if(instance!=null){
            instance.removeShutdownListener(cause -> {
                System.out.println("shout down RabbitMQ");
            });
        }
    }
}
