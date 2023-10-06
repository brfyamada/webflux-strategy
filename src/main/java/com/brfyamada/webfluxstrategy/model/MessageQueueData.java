package com.brfyamada.webfluxstrategy.model;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class MessageQueueData {
    private Object body;
    private Map<String, String> attributes;
}
