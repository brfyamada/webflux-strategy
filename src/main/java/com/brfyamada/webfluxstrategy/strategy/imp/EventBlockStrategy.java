package com.brfyamada.webfluxstrategy.strategy.imp;

import com.brfyamada.webfluxstrategy.domain.Event;
import com.brfyamada.webfluxstrategy.enums.EventEnum;
import com.brfyamada.webfluxstrategy.services.EventProcessorService;
import com.brfyamada.webfluxstrategy.strategy.EventStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EventBlockStrategy extends EventStrategy {

    @Autowired
    private EventProcessorService eventProcessorService;

    @Override
    public boolean doesApply(Event event) {
        return EventEnum.EventBlock.getName().equals(event.getEventType());
    }

    @Override
    public Event process(Event event) {
        return eventProcessorService.processorExecute(event, getStrategyCode(event));
    }

    @Override
    public int getStrategyCode(Event event) {

        for(EventEnum enumerator: EventEnum.values()){
            if(enumerator.getName().equals(event.getEventType())){
                return enumerator.getCode();
            }
        }
        throw new RuntimeException("EventType doe not exists!");
    }
}
