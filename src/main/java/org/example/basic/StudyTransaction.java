package org.example.basic;

public class StudyTransaction {

    /**
     * 将当前信道设置成事务模式。
     */
    public static void txSelect(){
        var channel = StudyChannel.getInstance();
        try {
            channel.txSelect();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 提交事务。
     */
    public static void txCommit(){
        var channel = StudyChannel.getInstance();
        try {
            channel.txCommit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 回滚事务。
     */
    public static void txRollback(){
        var channel = StudyChannel.getInstance();
        try {
            channel.txRollback();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
