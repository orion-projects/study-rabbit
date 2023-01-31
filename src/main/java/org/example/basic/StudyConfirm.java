package org.example.basic;

public class StudyConfirm {

    /**
     * 将当前信道设置成confirm模式。
     */
    public static void confirmSelect(){
        var channel = StudyChannel.getInstance();
        try {
            channel.confirmSelect();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
