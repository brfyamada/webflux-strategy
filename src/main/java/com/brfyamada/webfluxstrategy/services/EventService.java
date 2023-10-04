package com.brfyamada.webfluxstrategy.services;

import com.brfyamada.webfluxstrategy.domain.Event;
import com.brfyamada.webfluxstrategy.enums.EventEnum;
import com.brfyamada.webfluxstrategy.strategy.EventStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class EventService {

    @Autowired
    private List<EventStrategy> strategies;

    public Mono<Event> saveEvent(Event event) {
       return Mono.just(event)
               .flatMap(this::manageEvent)
               .flatMap(this::setSuccessMessage);
    }

    private Mono<Event> manageEvent(Event event){

        for(EventStrategy eventStrategy : strategies){
            if(eventStrategy.doesApply(event)){
                return Mono.just(eventStrategy.process(event));
            }
        }
        throw new RuntimeException("Event does not exists!");
    }

    private Mono<Event> setSuccessMessage(Event event){
        return Mono.just(event)
                .map(it -> {
                   String message = EventEnum.getEventByName(it.getEventType()).getSuccessMessage();
                   it.setMessage(message);
                   return it;
                });
    }
}
