# Seagull Platform

This jar provides all the _Seagull_ APIs that implementations need to provide implementations of.

This only contains APIs and no implementations.

## Requirements

This is intended to be a very simple to use service platform.

- Small.
- Trivial to use.
- Supporting multiple protocols of communication.
- Auto discovery.
- A service deployable should be runnable with java -jar MyService.jar

----

### SGProviderLookup

Internal class with static methods to lookup instances of interfaces. This uses ServiceLoader to lookup
implementations available on _CLASSPATH_.

### SGFactory

This uses SGProviderLookup to find an implementation of SGFactory, which is used to get instances of different objects.
You should not care about the instances and only use then via the interfaces. What is actually providing the instances
depends on what SGFactory implementations provide, and that depends on what is available on the classpath.

There might be other factory interfaces for other type of objects also, that allows different implementations.
