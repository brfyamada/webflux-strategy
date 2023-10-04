package com.brfyamada.webfluxstrategy.services;

import com.brfyamada.webfluxstrategy.domain.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventProcessorService {

    @Autowired
    private SumService sumService;

    public Event processorExecute(Event event, int newCode){

        Event newEvent = Event.builder()
                .id(event.getId())
                .eventType(event.getEventType())
                .version(sumService.sum(newCode))
                .build();

        return newEvent;

    }

}
