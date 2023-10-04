package com.brfyamada.webfluxstrategy.strategy;

import com.brfyamada.webfluxstrategy.domain.Event;

public interface EventStrategy {

    boolean doesApply(Event event);

    Event process(Event event);

    int getStrategyCode(Event event);

}
