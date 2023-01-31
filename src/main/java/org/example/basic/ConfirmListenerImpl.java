package org.example.basic;

import com.rabbitmq.client.ConfirmListener;

import java.io.IOException;

public class ConfirmListenerImpl implements ConfirmListener {
    @Override
    public void handleAck(long deliveryTag, boolean multiple) throws IOException {
        System.out.println("handleAck");
    }

    @Override
    public void handleNack(long deliveryTag, boolean multiple) throws IOException {
        System.out.println("handleNack");
    }
}
