# Seagull Platform

This jar provides all the _Seagull_ APIs that implementations need to provide implementations of.

This only contains APIs and no implementations.

## Concepts

This is intended to be a very simple to use service platform, and it does not in
any way try to hide reality and make things look like other things they really
aren't!

Thereby few things will look like "simple" classes! This is also done in Groovy
and makes use of Groovy's eminent Closures. If you only have developed Java with
simple classes then this will look a bit different. That said, it isn't difficult.
Seagull aims at being very simple!

There is one way, and only one way to communicate with other code: send and
receive messages. DO NOTE that a response to a message will be another message
sent to the service that sent the original message, and possibly more can
act on the response message. There are no different kinds of messages, there
are only messages. So if a message is sent and a response to it is wanted, then
the code has to also listen to the response message and act on it when it comes.

So when a message is sent, that is it! The sending code is done. But this message
can trigger another message to be sent and the same service that sent the original
message might be called with a response, but again, the code that sent the original
message is done. When a response is received you have to deal with it from there.

Seagull code does not do calls and waits for response! It trigger things to happen
in some code and react to possible results of sent message when such are received.

Each message received should be acted on without caring who/what sent it! More
than one service might receive the same message.

Any service sends a message without there being a service that picks it up,
will not do anything! So when designing code in Seagull you have to make sure
you deploy services that also listen to them. It is also fully legal for
a service to send a message that will be received by same service! It will
however be handled as any other received message.

It is possible for a service to send a message, that gets picked up by a another
service, which produce a new message that gets picked up by yet another service
which produces a new message that is picked up by the originating service!

It is all about acting on messages and sending messages. Most services will do
both, but there is no forced request -> response flow!! That said, a received
message might have an "in-response-to"<uuid> in the message header. Each
message will have a unique id in it.

If a message is sent and no one is interested in it there will be an error
message produced in the log (which is written to by sending a log message)!

This might seem strange and confusing, but it will make code simple and
truly reusable, and very testable.

Each service should be rather tiny and do one and only one thing! Then services
can be spread out over the network. My default implementation aims to find all
services deployed on same subnet. Also note a Seagull service jar file can
always be run with java -jar, and can contain one single service or many of
them. The service implementations should not care how they are deployed!

The biggest goal of all in Seagull is to make implementations as simple
as physically possible! The KISS rule should rule here!

----

### SGProviderLookup

Internal class with static methods to lookup instances of interfaces.

### SGFactory

This uses SGProviderLookup to find an implementation of SGFactory, which is used to
get instances of different objects. You should not care about the instances and only
use then via the interfaces. What is actually providing the instances depends on
what SGFactory implementations provide, and that depends on what is available on
the classpath.

There might be other factory interfaces for other type of objects also, that allows
different implementations.

