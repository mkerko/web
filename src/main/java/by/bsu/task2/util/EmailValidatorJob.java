package by.bsu.task2.util;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.io.IOException;

/**
 * Created by Mikhail on 03.11.2017.
 */
public class EmailValidatorJob implements Job{

    public void execute(JobExecutionContext context) throws JobExecutionException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername(Util.NAME);
        factory.setPassword(Util.PASSWORD);
        factory.setVirtualHost(Util.VHOST);
        factory.setHost(Util.HOST);
        factory.setPort(Util.PORT);
        try {
            Connection conn = factory.newConnection();
            Channel channel = conn.createChannel();
            String exchangeName = "myExchange";
            String routingKey = "testRoute";

            byte[] messageBodyBytes = (context.getJobDetail().getJobDataMap().getString("email")).getBytes();
            channel.basicPublish(exchangeName, routingKey, MessageProperties.PERSISTENT_TEXT_PLAIN, messageBodyBytes);
            channel.close();
            conn.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
