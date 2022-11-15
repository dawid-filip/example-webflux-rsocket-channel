package com.pl.df.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.rsocket.RSocketRequester;

@Configuration
public class ClientConfiguration {

    @Bean
    public ServerRSSocketProperties serverRSSocketProperties() {
        return new ServerRSSocketProperties();
    }

    @Bean
    public RSocketRequester rSocketRequester(RSocketRequester.Builder builder,
                                             ServerRSSocketProperties serverRSSocketProperties) {
        return builder.connectTcp(
                    serverRSSocketProperties.getAddress(),
                    serverRSSocketProperties.getPort())
                .block();
    }

}
