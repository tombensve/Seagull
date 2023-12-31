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
receive messages.

Note that a Seagull service jar file can always be run with java -jar, and can 
contain one single service or many of them. The service implementations should 
not care how they are deployed!

The biggest goal of all in Seagull is to make implementations as simple
as physically possible! The KISS rule rules here!

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

