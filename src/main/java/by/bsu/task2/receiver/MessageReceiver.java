package by.bsu.task2.receiver;

import by.bsu.task2.util.MessageThread;
import by.bsu.task2.util.Util;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

import java.io.IOException;

/**
 * Created by Mikhail on 03.11.2017.
 */
public class MessageReceiver {

    public static void main(String[] args) throws IOException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername(Util.NAME);
        factory.setPassword(Util.PASSWORD);
        factory.setVirtualHost(Util.VHOST);
        factory.setHost(Util.HOST);
        factory.setPort(Util.PORT);
        Connection conn = factory.newConnection();
        Channel channel = conn.createChannel();
        String exchangeName = Util.EXCHANGENAME;
        String queueName = "myQueue";
        String routingKey = Util.ROUTINGKEY;
        boolean durable = true;
        channel.exchangeDeclare(exchangeName, "direct", durable);
        channel.queueDeclare(queueName, durable, false, false, null);
        channel.queueBind(queueName, exchangeName, routingKey);
        QueueingConsumer consumer = new QueueingConsumer(channel);
        channel.basicConsume(queueName, false, consumer);
        boolean run = true;
        while (run) {
            QueueingConsumer.Delivery delivery;
            try {
                delivery = consumer.nextDelivery();
                new MessageThread(channel, new String(delivery.getBody()), delivery.getEnvelope().getDeliveryTag()).start();
            } catch (InterruptedException ie) {
                continue;
            }
        }
        channel.close();
        conn.close();
    }
}
