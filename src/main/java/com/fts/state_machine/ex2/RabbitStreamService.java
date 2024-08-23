package com.fts.state_machine.ex2;


import com.rabbitmq.stream.Consumer;
import com.rabbitmq.stream.Environment;
import com.rabbitmq.stream.OffsetSpecification;
import com.rabbitmq.stream.Producer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.Duration;
import  java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;


@Service
public class RabbitStreamService {

    private static final Logger logger = LoggerFactory.getLogger(RabbitStreamService.class);

    private static final String userName = "user-plt-ord";
    private static final String password = "123123";
    private static final String virtualHost = "plt-orders";
    private static final String hostName = "serious-lobster.rmq.cloudamqp.com";
    private static final int portNumber = 5672;

    private static final String stream = "my-stream";

//    private static final Environment environment = Environment.builder().build();

    public void createStream() {

        logger.info("Starting creating streams queue...");

//        environment.streamCreator()
//                .stream(stream)
//                //.maxAge(Duration.ofDays(7))
//                .maxAge(Duration.ofSeconds(20))
//                .create();

        logger.info("done...");
    }

    public void publish(int startCount) throws InterruptedException {

        logger.info("Starting publishing...");
//        int messageCount = 10;
//
//        CountDownLatch publishConfirmLatch = new CountDownLatch(messageCount);
//
//        Producer producer = environment.producerBuilder()
//                .stream(stream)
//                .build();
//
//        IntStream.range(0, messageCount)
//                .forEach(i -> producer.send(
//                        producer.messageBuilder()
//                                .addData(String.valueOf(Math.addExact(i, startCount)).getBytes())
//                                .build(),
//                        confirmationStatus -> publishConfirmLatch.countDown()
//                ));
//
//        publishConfirmLatch.await(10, TimeUnit.SECONDS);
//        producer.close();

//        logger.info("Published {} messages", messageCount);
    }

    public void consume() throws InterruptedException {

        logger.info("Starting consuming...");

//        int messageCount = 10;
//
//        AtomicLong sum = new AtomicLong(0);
//
//        CountDownLatch consumeLatch = new CountDownLatch(messageCount);
//
//        Consumer consumer = environment.consumerBuilder()
//                .stream(stream)
//                .offset(OffsetSpecification.first())
//                .messageHandler((offset, message) -> {
//
//                    var messageString = new String(message.getBodyAsBinary());
//                    logger.info("Received message: {}", messageString);
//
//                    sum.addAndGet(Long.parseLong(messageString));
//                    consumeLatch.countDown();
//
//                })
//                .build();
//
//        consumeLatch.await(10, TimeUnit.SECONDS);

//        logger.info("Sum: {}", sum.get());

//        consumer.close();
    }

}
