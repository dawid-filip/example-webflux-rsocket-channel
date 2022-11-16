# example-webflux-rsocket-channel
Simple example of [RSocket](https://docs.spring.io/spring-framework/docs/current/reference/html/rsocket.html) channeling (streaming) *server* & *client* implementation with conjunction of [WebFlux](https://docs.spring.io/spring-framework/docs/current/reference/html/web-reactive.html).

## How to run and test
Follow steps in order:
1. Package `example-webflux-rsocket-lib` module and then,
2. Run `example-webflux-rsocket-server` module and,
3. Run `example-webflux-rsocket-client` module.

Once `server` and `client` are up and running you should see logs as presented below for:
<details><summary>client</summary>

```

2022-11-16 10:48:43.308  INFO 18056 --- [           main] o.s.b.rsocket.netty.NettyRSocketServer   : Netty RSocket started on port(s): 8182
2022-11-16 10:48:43.315  INFO 18056 --- [           main] c.ExampleWebfluxRsocketClientApplication : Started ExampleWebfluxRsocketClientApplication in 1.373 seconds (JVM running for 1.652)
2022-11-16 10:48:43.318  INFO 18056 --- [           main] com.pl.df.client.ClientService           : Checking availability of RSocket connection...
2022-11-16 10:48:43.322  INFO 18056 --- [           main] com.pl.df.client.ClientService           : Checking availability of RSocket connection...
2022-11-16 10:48:43.354  INFO 18056 --- [           main] com.pl.df.client.MessageComponent        : Generating 10 messages for server...
2022-11-16 10:48:43.569  INFO 18056 --- [     parallel-2] com.pl.df.client.MessageComponent        : Sending [channel 1] message to server.
2022-11-16 10:48:43.603  INFO 18056 --- [actor-tcp-nio-2] com.pl.df.client.ClientService           : Received [channel back 1] message back from server.
2022-11-16 10:48:43.769  INFO 18056 --- [     parallel-2] com.pl.df.client.MessageComponent        : Sending [channel 2] message to server.
2022-11-16 10:48:43.771  INFO 18056 --- [actor-tcp-nio-2] com.pl.df.client.ClientService           : Received [channel back 2] message back from server.
2022-11-16 10:48:43.956  INFO 18056 --- [     parallel-2] com.pl.df.client.MessageComponent        : Sending [channel 3] message to server.
2022-11-16 10:48:43.957  INFO 18056 --- [actor-tcp-nio-2] com.pl.df.client.ClientService           : Received [channel back 3] message back from server.
2022-11-16 10:48:44.155  INFO 18056 --- [     parallel-2] com.pl.df.client.MessageComponent        : Sending [channel 4] message to server.
2022-11-16 10:48:44.157  INFO 18056 --- [actor-tcp-nio-2] com.pl.df.client.ClientService           : Received [channel back 4] message back from server.
2022-11-16 10:48:44.355  INFO 18056 --- [     parallel-2] com.pl.df.client.MessageComponent        : Sending [channel 5] message to server.
2022-11-16 10:48:44.357  INFO 18056 --- [actor-tcp-nio-2] com.pl.df.client.ClientService           : Received [channel back 5] message back from server.
2022-11-16 10:48:44.558  INFO 18056 --- [     parallel-2] com.pl.df.client.MessageComponent        : Sending [channel 6] message to server.
2022-11-16 10:48:44.560  INFO 18056 --- [actor-tcp-nio-2] com.pl.df.client.ClientService           : Received [channel back 6] message back from server.
2022-11-16 10:48:44.761  INFO 18056 --- [     parallel-2] com.pl.df.client.MessageComponent        : Sending [channel 7] message to server.
2022-11-16 10:48:44.766  INFO 18056 --- [actor-tcp-nio-2] com.pl.df.client.ClientService           : Received [channel back 7] message back from server.
2022-11-16 10:48:44.963  INFO 18056 --- [     parallel-2] com.pl.df.client.MessageComponent        : Sending [channel 8] message to server.
2022-11-16 10:48:44.965  INFO 18056 --- [actor-tcp-nio-2] com.pl.df.client.ClientService           : Received [channel back 8] message back from server.
2022-11-16 10:48:45.165  INFO 18056 --- [     parallel-2] com.pl.df.client.MessageComponent        : Sending [channel 9] message to server.
2022-11-16 10:48:45.166  INFO 18056 --- [actor-tcp-nio-2] com.pl.df.client.ClientService           : Received [channel back 9] message back from server.
2022-11-16 10:48:45.367  INFO 18056 --- [     parallel-2] com.pl.df.client.MessageComponent        : Sending [channel 10] message to server.
2022-11-16 10:48:45.369  INFO 18056 --- [actor-tcp-nio-2] com.pl.df.client.ClientService           : Received [channel back 10] message back from server.
2022-11-16 10:48:45.369  INFO 18056 --- [actor-tcp-nio-2] com.pl.df.client.MessageComponent        : Generating 10 object-messages for server...
2022-11-16 10:48:45.588  INFO 18056 --- [     parallel-3] com.pl.df.client.MessageComponent        : Sending [ObjectMessage(number=1, clientMessage=channel, serverMessage=null)] message to server.
2022-11-16 10:48:45.650  INFO 18056 --- [actor-tcp-nio-2] com.pl.df.client.ClientService           : Received [ObjectMessage(number=1, clientMessage=channel, serverMessage=channel 1)] message back from server.
2022-11-16 10:48:45.771  INFO 18056 --- [     parallel-3] com.pl.df.client.MessageComponent        : Sending [ObjectMessage(number=2, clientMessage=channel, serverMessage=null)] message to server.
2022-11-16 10:48:45.775  INFO 18056 --- [actor-tcp-nio-2] com.pl.df.client.ClientService           : Received [ObjectMessage(number=2, clientMessage=channel, serverMessage=channel 2)] message back from server.
2022-11-16 10:48:45.971  INFO 18056 --- [     parallel-3] com.pl.df.client.MessageComponent        : Sending [ObjectMessage(number=3, clientMessage=channel, serverMessage=null)] message to server.
2022-11-16 10:48:45.976  INFO 18056 --- [actor-tcp-nio-2] com.pl.df.client.ClientService           : Received [ObjectMessage(number=3, clientMessage=channel, serverMessage=channel 3)] message back from server.
2022-11-16 10:48:46.172  INFO 18056 --- [     parallel-3] com.pl.df.client.MessageComponent        : Sending [ObjectMessage(number=4, clientMessage=channel, serverMessage=null)] message to server.
2022-11-16 10:48:46.174  INFO 18056 --- [actor-tcp-nio-2] com.pl.df.client.ClientService           : Received [ObjectMessage(number=4, clientMessage=channel, serverMessage=channel 4)] message back from server.
2022-11-16 10:48:46.371  INFO 18056 --- [     parallel-3] com.pl.df.client.MessageComponent        : Sending [ObjectMessage(number=5, clientMessage=channel, serverMessage=null)] message to server.
2022-11-16 10:48:46.375  INFO 18056 --- [actor-tcp-nio-2] com.pl.df.client.ClientService           : Received [ObjectMessage(number=5, clientMessage=channel, serverMessage=channel 5)] message back from server.
2022-11-16 10:48:46.571  INFO 18056 --- [     parallel-3] com.pl.df.client.MessageComponent        : Sending [ObjectMessage(number=6, clientMessage=channel, serverMessage=null)] message to server.
2022-11-16 10:48:46.573  INFO 18056 --- [actor-tcp-nio-2] com.pl.df.client.ClientService           : Received [ObjectMessage(number=6, clientMessage=channel, serverMessage=channel 6)] message back from server.
2022-11-16 10:48:46.773  INFO 18056 --- [     parallel-3] com.pl.df.client.MessageComponent        : Sending [ObjectMessage(number=7, clientMessage=channel, serverMessage=null)] message to server.
2022-11-16 10:48:46.776  INFO 18056 --- [actor-tcp-nio-2] com.pl.df.client.ClientService           : Received [ObjectMessage(number=7, clientMessage=channel, serverMessage=channel 7)] message back from server.
2022-11-16 10:48:46.974  INFO 18056 --- [     parallel-3] com.pl.df.client.MessageComponent        : Sending [ObjectMessage(number=8, clientMessage=channel, serverMessage=null)] message to server.
2022-11-16 10:48:46.979  INFO 18056 --- [actor-tcp-nio-2] com.pl.df.client.ClientService           : Received [ObjectMessage(number=8, clientMessage=channel, serverMessage=channel 8)] message back from server.
2022-11-16 10:48:47.175  INFO 18056 --- [     parallel-3] com.pl.df.client.MessageComponent        : Sending [ObjectMessage(number=9, clientMessage=channel, serverMessage=null)] message to server.
2022-11-16 10:48:47.179  INFO 18056 --- [actor-tcp-nio-2] com.pl.df.client.ClientService           : Received [ObjectMessage(number=9, clientMessage=channel, serverMessage=channel 9)] message back from server.
2022-11-16 10:48:47.377  INFO 18056 --- [     parallel-3] com.pl.df.client.MessageComponent        : Sending [ObjectMessage(number=10, clientMessage=channel, serverMessage=null)] message to server.
2022-11-16 10:48:47.379  INFO 18056 --- [actor-tcp-nio-2] com.pl.df.client.ClientService           : Received [ObjectMessage(number=10, clientMessage=channel, serverMessage=channel 10)] message back from server.

```

</details>
<details><summary>server</summary>

```

2022-11-16 10:47:54.933  INFO 10352 --- [           main] o.s.b.rsocket.netty.NettyRSocketServer   : Netty RSocket started on port(s): 8181
2022-11-16 10:47:54.939  INFO 10352 --- [           main] s.ExampleWebfluxRsocketServerApplication : Started ExampleWebfluxRsocketServerApplication in 1.166 seconds (JVM running for 1.445)
2022-11-16 10:48:43.594  INFO 10352 --- [ctor-http-nio-3] com.pl.df.server.ServerController        : Received [channel 1] message from client.
2022-11-16 10:48:43.595  INFO 10352 --- [ctor-http-nio-3] com.pl.df.server.ServerController        : Sending [channel back 1] message back to client.
2022-11-16 10:48:43.770  INFO 10352 --- [ctor-http-nio-3] com.pl.df.server.ServerController        : Received [channel 2] message from client.
2022-11-16 10:48:43.770  INFO 10352 --- [ctor-http-nio-3] com.pl.df.server.ServerController        : Sending [channel back 2] message back to client.
2022-11-16 10:48:43.957  INFO 10352 --- [ctor-http-nio-3] com.pl.df.server.ServerController        : Received [channel 3] message from client.
2022-11-16 10:48:43.957  INFO 10352 --- [ctor-http-nio-3] com.pl.df.server.ServerController        : Sending [channel back 3] message back to client.
2022-11-16 10:48:44.156  INFO 10352 --- [ctor-http-nio-3] com.pl.df.server.ServerController        : Received [channel 4] message from client.
2022-11-16 10:48:44.156  INFO 10352 --- [ctor-http-nio-3] com.pl.df.server.ServerController        : Sending [channel back 4] message back to client.
2022-11-16 10:48:44.356  INFO 10352 --- [ctor-http-nio-3] com.pl.df.server.ServerController        : Received [channel 5] message from client.
2022-11-16 10:48:44.356  INFO 10352 --- [ctor-http-nio-3] com.pl.df.server.ServerController        : Sending [channel back 5] message back to client.
2022-11-16 10:48:44.559  INFO 10352 --- [ctor-http-nio-3] com.pl.df.server.ServerController        : Received [channel 6] message from client.
2022-11-16 10:48:44.559  INFO 10352 --- [ctor-http-nio-3] com.pl.df.server.ServerController        : Sending [channel back 6] message back to client.
2022-11-16 10:48:44.765  INFO 10352 --- [ctor-http-nio-3] com.pl.df.server.ServerController        : Received [channel 7] message from client.
2022-11-16 10:48:44.765  INFO 10352 --- [ctor-http-nio-3] com.pl.df.server.ServerController        : Sending [channel back 7] message back to client.
2022-11-16 10:48:44.964  INFO 10352 --- [ctor-http-nio-3] com.pl.df.server.ServerController        : Received [channel 8] message from client.
2022-11-16 10:48:44.964  INFO 10352 --- [ctor-http-nio-3] com.pl.df.server.ServerController        : Sending [channel back 8] message back to client.
2022-11-16 10:48:45.166  INFO 10352 --- [ctor-http-nio-3] com.pl.df.server.ServerController        : Received [channel 9] message from client.
2022-11-16 10:48:45.166  INFO 10352 --- [ctor-http-nio-3] com.pl.df.server.ServerController        : Sending [channel back 9] message back to client.
2022-11-16 10:48:45.368  INFO 10352 --- [ctor-http-nio-3] com.pl.df.server.ServerController        : Received [channel 10] message from client.
2022-11-16 10:48:45.368  INFO 10352 --- [ctor-http-nio-3] com.pl.df.server.ServerController        : Sending [channel back 10] message back to client.
2022-11-16 10:48:45.640  INFO 10352 --- [ctor-http-nio-3] com.pl.df.server.ServerController        : Received [ObjectMessage(number=1, clientMessage=channel, serverMessage=null)] message from client.
2022-11-16 10:48:45.641  INFO 10352 --- [ctor-http-nio-3] com.pl.df.server.ServerController        : Sending [ObjectMessage(number=1, clientMessage=channel, serverMessage=channel 1)] message back to client.
2022-11-16 10:48:45.773  INFO 10352 --- [ctor-http-nio-3] com.pl.df.server.ServerController        : Received [ObjectMessage(number=2, clientMessage=channel, serverMessage=null)] message from client.
2022-11-16 10:48:45.774  INFO 10352 --- [ctor-http-nio-3] com.pl.df.server.ServerController        : Sending [ObjectMessage(number=2, clientMessage=channel, serverMessage=channel 2)] message back to client.
2022-11-16 10:48:45.973  INFO 10352 --- [ctor-http-nio-3] com.pl.df.server.ServerController        : Received [ObjectMessage(number=3, clientMessage=channel, serverMessage=null)] message from client.
2022-11-16 10:48:45.973  INFO 10352 --- [ctor-http-nio-3] com.pl.df.server.ServerController        : Sending [ObjectMessage(number=3, clientMessage=channel, serverMessage=channel 3)] message back to client.
2022-11-16 10:48:46.173  INFO 10352 --- [ctor-http-nio-3] com.pl.df.server.ServerController        : Received [ObjectMessage(number=4, clientMessage=channel, serverMessage=null)] message from client.
2022-11-16 10:48:46.173  INFO 10352 --- [ctor-http-nio-3] com.pl.df.server.ServerController        : Sending [ObjectMessage(number=4, clientMessage=channel, serverMessage=channel 4)] message back to client.
2022-11-16 10:48:46.373  INFO 10352 --- [ctor-http-nio-3] com.pl.df.server.ServerController        : Received [ObjectMessage(number=5, clientMessage=channel, serverMessage=null)] message from client.
2022-11-16 10:48:46.373  INFO 10352 --- [ctor-http-nio-3] com.pl.df.server.ServerController        : Sending [ObjectMessage(number=5, clientMessage=channel, serverMessage=channel 5)] message back to client.
2022-11-16 10:48:46.572  INFO 10352 --- [ctor-http-nio-3] com.pl.df.server.ServerController        : Received [ObjectMessage(number=6, clientMessage=channel, serverMessage=null)] message from client.
2022-11-16 10:48:46.572  INFO 10352 --- [ctor-http-nio-3] com.pl.df.server.ServerController        : Sending [ObjectMessage(number=6, clientMessage=channel, serverMessage=channel 6)] message back to client.
2022-11-16 10:48:46.774  INFO 10352 --- [ctor-http-nio-3] com.pl.df.server.ServerController        : Received [ObjectMessage(number=7, clientMessage=channel, serverMessage=null)] message from client.
2022-11-16 10:48:46.775  INFO 10352 --- [ctor-http-nio-3] com.pl.df.server.ServerController        : Sending [ObjectMessage(number=7, clientMessage=channel, serverMessage=channel 7)] message back to client.
2022-11-16 10:48:46.977  INFO 10352 --- [ctor-http-nio-3] com.pl.df.server.ServerController        : Received [ObjectMessage(number=8, clientMessage=channel, serverMessage=null)] message from client.
2022-11-16 10:48:46.977  INFO 10352 --- [ctor-http-nio-3] com.pl.df.server.ServerController        : Sending [ObjectMessage(number=8, clientMessage=channel, serverMessage=channel 8)] message back to client.
2022-11-16 10:48:47.178  INFO 10352 --- [ctor-http-nio-3] com.pl.df.server.ServerController        : Received [ObjectMessage(number=9, clientMessage=channel, serverMessage=null)] message from client.
2022-11-16 10:48:47.178  INFO 10352 --- [ctor-http-nio-3] com.pl.df.server.ServerController        : Sending [ObjectMessage(number=9, clientMessage=channel, serverMessage=channel 9)] message back to client.
2022-11-16 10:48:47.378  INFO 10352 --- [ctor-http-nio-3] com.pl.df.server.ServerController        : Received [ObjectMessage(number=10, clientMessage=channel, serverMessage=null)] message from client.
2022-11-16 10:48:47.378  INFO 10352 --- [ctor-http-nio-3] com.pl.df.server.ServerController        : Sending [ObjectMessage(number=10, clientMessage=channel, serverMessage=channel 10)] message back to client.
```
</details>

As you can see from above logs: 
- the `client` first sent 10 string type messages to the <i><b>channel</b></i> channel, once it's done 
- the `client` sent next 10 object type messages to second <i><b>object-channel</b></i> channel.

## Requirements
- `JDK 17` or higher