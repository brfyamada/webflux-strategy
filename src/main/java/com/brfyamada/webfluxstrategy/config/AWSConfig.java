package com.brfyamada.webfluxstrategy.config;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsAsyncClient;
import software.amazon.awssdk.utils.StringUtils;

import java.net.URI;

@Configuration
@AllArgsConstructor
public class AWSConfig {

    private final AWSProperties awsProperties;

    private final ApplicationProperties applicationProperties;

    @Bean
    public SqsAsyncClient sqsAsyncClient(){
        var builder = SqsAsyncClient.builder()
                .region(Region.of(awsProperties.getRegion()));


        if(StringUtils.equals(applicationProperties.getEnv(), "LOCAL")){
            builder.endpointOverride(URI.create("http://localhost:4566"));
        }

        return builder.build();

    }

}
