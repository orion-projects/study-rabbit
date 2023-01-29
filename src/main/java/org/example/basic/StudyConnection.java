package org.example.basic;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.net.URI;

/**
 * Connection用来创建多个Channel实例。Channel实例不能在线程间共享，应用程序
 * 应该为每个线程开辟一个Channel。
 */
public class StudyConnection {
    private static Connection instance;
    private static Connection uriInstance;

    private StudyConnection(){

    }

    synchronized public static Connection getInstance(){
        if(instance==null){
            instance = getConnection();
        }
        return instance;
    }

    synchronized public static Connection getUriInstance(){
        if(uriInstance==null){
            uriInstance = getConnectionByUri();
        }
        return uriInstance;
    }

    /**
     * 创建Connection。
     * @return Connection实例。
     */
    private static Connection getConnection(){
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername("guest");
        factory.setPassword("guest");
        factory.setVirtualHost("test");
        factory.setHost("127.0.0.1");
        factory.setPort(5672);
        Connection connection = null;
        try {
            connection = factory.newConnection();
        }catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * 使用URI创建Connection。
     * @return 返回Connection实例。
     */
    private static Connection getConnectionByUri(){
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = null;
        try {
            factory.setUri(URI.create("amqp://guest:guest@127.0.0.1:5672/test"));
            connection = factory.newConnection();
        }catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }
}
