package com.brfyamada.webfluxstrategy.infra.sqs;

import com.brfyamada.webfluxstrategy.model.MessageQueueData;
import reactor.core.publisher.Mono;
import software.amazon.awssdk.services.sqs.model.Message;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface ISQSClientService {

    Mono<String> sendMessage(String queueUrl, MessageQueueData message);
    List<Message> receiveMessage(String queueUrl, Integer VisibilityTimeout, Integer maxNumberOfMessages) throws ExecutionException, InterruptedException;
    Mono<Boolean> deleteMessageFromQueue(String queueUrl, String receiptHandle);
    String getAttributes(Message message, String attributes, String defaultValue);
}
