package com.pl.df.client;

import com.pl.df.lib.ObjectMessage;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

@Component
@Log4j2
public class MessageComponent {

    private final int MESSAGE_LIMIT = 20;
    private static AtomicInteger messageNumber = new AtomicInteger(1);
    private static AtomicInteger objectMessageNumber = new AtomicInteger(1);

    public Flux<String> getClientRequestMessages() {
        return Flux.interval(Duration.ofMillis(200))
                .map(message -> "channel " + messageNumber.getAndIncrement())
                .doOnNext(message -> log.info("Sending [" + message + "] message to server."))
                .take(MESSAGE_LIMIT)
                .doOnSubscribe(subscription -> log.info("Generating " + MESSAGE_LIMIT + " messages for server..."));
    }

    public Flux<ObjectMessage> getClientRequestObjectMessages() {
        return Flux.interval(Duration.ofMillis(200))
                .map(message -> {
                    final Integer number = objectMessageNumber.getAndIncrement();
                    ObjectMessage objectMessage = new ObjectMessage(number, "channel", null);
                    log.info("Sending [" + objectMessage + "] message to server.");
                    return objectMessage;
                })
                .take(MESSAGE_LIMIT)
                .doOnSubscribe(subscription -> log.info("Generating " + MESSAGE_LIMIT + " object-messages for server..."));
    }

}
