package com.pl.df.server;

import com.pl.df.lib.ObjectMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicInteger;

@Controller
@RequiredArgsConstructor
@Log4j2
public class ServerController {

    private static AtomicInteger number = new AtomicInteger(1);

    @MessageMapping("channel")
    public Flux<String> channel(@Payload Flux<String> channels) {

        return channels
                .map(request -> {
                    log.info("Received [" + request + "] message from client.");
                    return request;
                })
                .map(request -> "channel back " + number.getAndIncrement())
                .doOnNext(i -> log.info("Sending [" + i + "] message back to client."));
    }

    @MessageMapping("object-channel")
    public Flux<ObjectMessage> objectChannel(@Payload Flux<ObjectMessage> channels) {

        return channels.map(request -> {
                    log.info("Received [" + request + "] message from client.");
                    request.setServerMessage(request.getClientMessage() + " " + request.getNumber());
                    return request;
                })
                .doOnNext(response -> log.info("Sending [" + response + "] message back to client."));
    }

}
