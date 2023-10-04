package com.brfyamada.webfluxstrategy.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Env {

    @Value("${success-block-message}")
    public static String successBlockMessage;

    @Value("${success-unblock-message}")
    public String successUnblockMessage;

    @Value("${success-cancel-message}")
    public String successCancelMessage;
}
