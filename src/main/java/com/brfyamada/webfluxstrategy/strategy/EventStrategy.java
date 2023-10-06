package com.brfyamada.webfluxstrategy.strategy;

import com.brfyamada.webfluxstrategy.domain.Event;

public abstract class EventStrategy {

    public abstract boolean doesApply(Event event);

    public abstract Event process(Event event);

    public abstract int getStrategyCode(Event event);

}
