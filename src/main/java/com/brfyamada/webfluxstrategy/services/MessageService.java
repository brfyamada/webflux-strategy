package com.brfyamada.webfluxstrategy.services;

import com.brfyamada.webfluxstrategy.domain.Event;
import com.brfyamada.webfluxstrategy.infra.sqs.ISQSClientService;
import com.brfyamada.webfluxstrategy.model.MessageQueueData;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Map;

@Service
@AllArgsConstructor
public class MessageService {

    private final ISQSClientService sqsClientService;

    public Mono<String> sendMessage3(String queue, Event event) {
        return Mono.just(event)
                .map(it -> sqsClientService.sendMessage(queue, buildMessageQueueData(event)))
                .thenReturn("Mensagem Enviada com sucesso");
    }

    public Mono<String> sendMessage2(String queue, Event event) {
        return sqsClientService.sendMessage(queue, buildMessageQueueData(event));

        //.thenReturn("Mensagem Enviada com sucesso");
    }

    public Mono<String> sendMessage(String queue, Event event) {
        return sqsClientService.sendMessage(queue, buildMessageQueueData(event));

    }

    private MessageQueueData buildMessageQueueData(Event event){
        Map<String, String> attributes = Map.of(
                "id", event.getId()
        );
        return MessageQueueData.builder()
                .attributes(attributes)
                .body(event.toMessageDomain())
                .build();
    }

}
