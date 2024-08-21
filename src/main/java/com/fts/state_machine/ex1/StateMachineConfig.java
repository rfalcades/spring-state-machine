package com.fts.state_machine.ex1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.listener.StateMachineListener;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.state.State;

import java.util.EnumSet;

@Configuration
@EnableStateMachine
public class StateMachineConfig extends EnumStateMachineConfigurerAdapter<States, Events> {

    private static final Logger logger = LoggerFactory.getLogger(StateMachineConfig.class);

    @Override
    public void configure(StateMachineConfigurationConfigurer<States, Events> config)
            throws Exception
    {
        config
            .withConfiguration()
                .autoStartup(true);
                //.listener(listener());
    }

    @Override
    public void configure(StateMachineStateConfigurer<States, Events> states)
            throws Exception {
        states
                .withStates()
                .initial(States.PENDING)
                .states(EnumSet.allOf(States.class));
                //.state(States.S1, action1(), action2())
                //.state(States.S2);
    }

    @Bean
    public Action<States, Events> confirm() {
        return new Action<States, Events>() {

            @Override
            public void execute(StateContext<States, Events> context) {
                logger.info(" ");
                logger.info("confirm");
                logger.info("Source ...: {}", context.getSource().getId());

//                if (context.getSource().getId() == States.SI)
//                    logger.info("action1 from SI");


                logger.info("Target ...: {}", context.getTarget().getId());
                logger.info(" ");
            }
        };
    }

    @Bean
    public Action<States, Events> deliver() {
        return new Action<States, Events>() {

            @Override
            public void execute(StateContext<States, Events> context) {
                logger.info(" ");
                logger.info("deliver");
                logger.info("Source ...: {}", context.getSource().getId());
                logger.info("Target ...: {}", context.getTarget().getId());
                logger.info(" ");
            }
        };
    }
    @Override
    public void configure(StateMachineTransitionConfigurer<States, Events> transitions)
            throws Exception {
        transitions
            .withExternal()
                .source(States.PENDING).target(States.CONFIRMED).event(Events.CONFIRM).action(confirm())
                .and()
            .withExternal()
                .source(States.CONFIRMED).target(States.DELIVERED).event(Events.DELIVER).action(deliver());
    }

    @Bean
    public StateMachineListener<States, Events> listener() {
        return new StateMachineListenerAdapter<States, Events>() {
            @Override
            public void stateChanged(State<States, Events> from, State<States, Events> to) {
                logger.info("State change to {}", to.getId());
            }
        };
    }
}
