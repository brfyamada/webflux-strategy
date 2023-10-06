package com.brfyamada.webfluxstrategy.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("app")
public class ApplicationProperties {

    private String env;
}
