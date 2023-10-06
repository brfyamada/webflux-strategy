package com.brfyamada.webfluxstrategy.controllers;

import com.brfyamada.webfluxstrategy.domain.Event;
import com.brfyamada.webfluxstrategy.services.EventService;
import com.brfyamada.webfluxstrategy.services.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/events")
@AllArgsConstructor
public class EventController {

    private final EventService eventService;

    private final MessageService messageService;

    @GetMapping("/{id}")
    public Mono<Event> getEventById(@PathVariable String id) {
        if(id.equals("1")){
            return Mono.just(
                    Event.builder()
                            .id("1")
                            .eventType("event-test")
                            .message("event-received")
                            .version(1)
                            .build()
            );
        }

        throw new RuntimeException("Error");
    }


    @PostMapping("/event")
    public Mono<Event> saveEvent(@RequestBody Event event) {
        return eventService.saveEvent(event);
    }

    @PostMapping("/event-message")
    public Mono<String> sendEventToQueue(@RequestBody Event event) {

        String queue = "http://localhost:4566/000000000000/EventQueue";
        return messageService.sendMessage(queue, event);
    }
}
