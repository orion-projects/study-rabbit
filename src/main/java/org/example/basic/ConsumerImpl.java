package org.example.basic;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.ShutdownSignalException;

import java.io.IOException;

public class ConsumerImpl implements Consumer {
    @Override
    public void handleConsumeOk(String consumerTag) {
        System.out.println("handleConsumeOk" + consumerTag);
    }

    @Override
    public void handleCancelOk(String consumerTag) {
        System.out.println("handleCancelOk" + consumerTag);
    }

    @Override
    public void handleCancel(String consumerTag) throws IOException {
        System.out.println("handleCancel" + consumerTag);
    }

    @Override
    public void handleShutdownSignal(String consumerTag, ShutdownSignalException sig) {
        System.out.println("handleShutdownSignal" + consumerTag);
    }

    @Override
    public void handleRecoverOk(String consumerTag) {
        System.out.println("handleRecoverOk" + consumerTag);
    }

    @Override
    public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
        System.out.println("handleDelivery" + new String(body));
    }
}
