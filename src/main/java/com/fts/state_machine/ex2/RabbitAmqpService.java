package com.fts.state_machine.ex2;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

@Service
public class RabbitAmqpService {

    private static final Logger logger = LoggerFactory.getLogger(RabbitAmqpService.class);

    private static final String userName = "user-plt-ord";
    private static final String password = "123123";
    private static final String virtualHost = "plt-orders";
    private static final String hostName = "serious-lobster.rmq.cloudamqp.com";
    private static final int portNumber = 5672;

    public void process() {

        logger.info("RabbitStreamService starting...");

        try {
            ConnectionFactory factory = new ConnectionFactory();
//            factory.setUsername(userName);
//            factory.setPassword(password);
//            factory.setVirtualHost(virtualHost);
//            factory.setHost(hostName);
//            factory.setPort(portNumber);

            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();

            Map<String, Object> arguments = new HashMap<>();
            arguments.put("x-queue-type", "stream");
            arguments.put("max-age", 10_000); // 10 seconds
            //arguments.put("x-max-length-bytes", 20_000_000_000); // maximum stream size: 20 GB
            //arguments.put("x-stream-max-segment-size-bytes", 100_000_000); //

            channel.queueDeclare(
                    "plt-ord-fanout-stream3",
                    true,         // durable
                    false, false, // not exclusive, not auto-delete
                    arguments);

//            channel.basicPublish(
//                    "plt-ord-fanout-stream3",
//                    "",
//                    null,
//                    "Hello, World!".getBytes()
//            );

            //channel.close();
            //connection.close();

        } catch (IOException | TimeoutException e) {
           logger.error(e.getMessage());
           e.printStackTrace();
        }

        logger.info("done...");
    }


    public void process2() {

        logger.info("RabbitStreamService 2 starting...");

        try {

            ConnectionFactory factory = new ConnectionFactory();
//            factory.setUsername(userName);
//            factory.setPassword(password);
//            factory.setVirtualHost(virtualHost);
//            factory.setHost(hostName);
//            factory.setPort(portNumber);

            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();

            Map<String, Object> arguments = new HashMap<>();
            arguments.put("x-queue-type", "stream");
            arguments.put("max-age", 10_000); // 10 seconds
            //arguments.put("x-max-length-bytes", 20_000_000_000); // maximum stream size: 20 GB
            //arguments.put("x-stream-max-segment-size-bytes", 100_000_000); //

            channel.queueDeclare(
                    "plt-ord-fanout-stream3",
                    true,         // durable
                    false, false, // not exclusive, not auto-delete
                    arguments);

//            channel.basicPublish(
//                    "plt-ord-fanout-stream3",
//                    "",
//                    null,
//                    "Hello, World!".getBytes()
//            );

            //channel.close();
            //connection.close();

        } catch (IOException | TimeoutException e) {
           logger.error(e.getMessage());
           e.printStackTrace();
        }

        logger.info("done...");
    }

}
