package com.fts.state_machine;

import com.fts.state_machine.ex1.Events;
import com.fts.state_machine.ex1.States;
import com.fts.state_machine.ex2.RabbitStreamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class CommandLineStartup implements CommandLineRunner {

    @Autowired
    private StateMachine<States, Events> stateMachine;

    @Autowired
    private RabbitStreamService rabbitStreamService;

    @Override
    public void run(String... args) throws Exception {

//        Message<Events> message = MessageBuilder.withPayload(Events.CONFIRM).build();
//        stateMachine.sendEvent(Mono.just(message)).subscribe();
//
//        message = MessageBuilder.withPayload(Events.DELIVER).build();
//        stateMachine.sendEvent(Mono.just(message)).subscribe();

        //rabbitStreamService.publish();
        rabbitStreamService.consume();


    }
}
