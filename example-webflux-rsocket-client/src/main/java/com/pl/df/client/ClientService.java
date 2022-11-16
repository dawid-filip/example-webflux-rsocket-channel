package com.pl.df.client;

import com.pl.df.lib.ObjectMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import static com.pl.df.client.MessagePaths.*;

@Service
@RequiredArgsConstructor
@Log4j2
public class ClientService {

    private final RSocketRequester rSocketRequester;
    private final MessageComponent messageComponent;

    @EventListener(ApplicationReadyEvent.class)
    public void doOnApplicationReadyEvent() {
        this.rsocketChannelMessages()
                .thenMany(this.rsocketChannelObjectMessages())
                .subscribe();
    }

    public Flux<String> rsocketChannelMessages() {
        throwExceptionWhenRSocketIsUnavailable();

        var clientMessages = messageComponent.getClientRequestMessages();
        return rSocketRequester
                .route(MESSAGE_CHANNEL.toString())
                .data(clientMessages)
                .retrieveFlux(String.class)
                .doOnNext(response -> log.info("Received [" + response + "] message back from server."));
    }

    public Flux<ObjectMessage> rsocketChannelObjectMessages() {
        throwExceptionWhenRSocketIsUnavailable();

        var clientObjectMessages = messageComponent.getClientRequestObjectMessages();
        return rSocketRequester
                .route(OBJECT_MESSAGE_CHANNEL.toString())
                .data(clientObjectMessages)
                .retrieveFlux(ObjectMessage.class)
                .doOnNext(response -> log.info("Received [" + response + "] message back from server."));
    }

    // --- //

    private void throwExceptionWhenRSocketIsUnavailable() {
        log.info("Checking availability of RSocket connection...");

        var availability = this.rSocketRequester.rsocket().availability();

        if (availability == 0.0)    // 1.0 available | 0.0 unavailable
            throw new RuntimeException("The availability cannot be 0.0!");
    }


}
