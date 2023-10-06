package com.brfyamada.webfluxstrategy.infra.sqs;

import com.brfyamada.webfluxstrategy.model.MessageQueueData;
import com.brfyamada.webfluxstrategy.utils.JsonUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import software.amazon.awssdk.services.sqs.SqsAsyncClient;
import software.amazon.awssdk.services.sqs.model.Message;
import software.amazon.awssdk.services.sqs.model.MessageAttributeValue;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;
import software.amazon.awssdk.services.sqs.model.SendMessageResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@Service
@RequiredArgsConstructor
public class SQSClientService implements ISQSClientService{

    private final SqsAsyncClient sqsAsyncClient;

    @Override
    public Mono<String> sendMessage(String queueUrl, MessageQueueData message) {
        var request = SendMessageRequest.builder()
                .queueUrl(queueUrl)
                .messageBody(JsonUtils.toStringJson(message.getBody()))
                .messageAttributes(buildAttributes(message.getAttributes()))
                .build();
        return Mono.fromFuture(sqsAsyncClient.sendMessage(request))
                .map(SendMessageResponse::messageId);
    }

    @Override
    public List<Message> receiveMessage(String queueUrl, Integer VisibilityTimeout, Integer maxNumberOfMessages) throws ExecutionException, InterruptedException {
        return null;
    }

    @Override
    public Mono<Boolean> deleteMessageFromQueue(String queueUrl, String receiptHandle) {
        return null;
    }

    @Override
    public String getAttributes(Message message, String attributes, String defaultValue) {
        return null;
    }

    private Map<String, MessageAttributeValue> buildAttributes(Map<String, String> attributes){
        var messageAttributes = new HashMap<String, MessageAttributeValue>();
        if(attributes != null){
            for(var entry: attributes.entrySet()){
                messageAttributes.put(entry.getKey(), MessageAttributeValue.builder().stringValue(entry.getValue()).dataType("String").build());
            }
        }
        return messageAttributes;
    }
}
