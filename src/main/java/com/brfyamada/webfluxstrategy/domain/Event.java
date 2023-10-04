package com.brfyamada.webfluxstrategy.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Event {

    private String id;
    private String eventType;
    private String message;
    private int version;

}
