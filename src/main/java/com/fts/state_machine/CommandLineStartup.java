package com.fts.state_machine;

import com.fts.state_machine.ex1.Events;
import com.fts.state_machine.ex1.States;
import com.fts.state_machine.ex2.RabbitStreamService;
import com.fts.state_machine.model.Order;
import com.fts.state_machine.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
public class CommandLineStartup implements CommandLineRunner {

    @Autowired
    private StateMachine<States, Events> stateMachine;

    @Autowired
    private RabbitStreamService rabbitStreamService;

    @Autowired
    private OrderService orderService;

    @Override
    public void run(String... args) throws Exception {

//        Message<Events> message = MessageBuilder.withPayload(Events.CONFIRM).build();
//        stateMachine.sendEvent(Mono.just(message)).subscribe();
//
//        message = MessageBuilder.withPayload(Events.DELIVER).build();
//        stateMachine.sendEvent(Mono.just(message)).subscribe();

//        rabbitStreamService.createStream();
//        rabbitStreamService.publish(0);
//        rabbitStreamService.consume();



        orderService.addOrder(new Order(LocalDateTime.now(), "NEW", BigDecimal.valueOf(100) ));


    }
}
