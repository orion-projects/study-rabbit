package org.example.basic;

import com.rabbitmq.client.Channel;

public class StudyChannel {
    private static Channel instance = null;

    private StudyChannel(){

    }

    synchronized public static Channel getInstance(){
        if(instance==null){
            try {
                instance = StudyConnection.getInstance().createChannel();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        return instance;
    }
}
