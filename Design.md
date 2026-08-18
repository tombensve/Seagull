# SeaGull Design

This project aims at proving a service API based on sending messages, but not demanding any specific protocol. The protocol depends entirely on the implementation. 

The first implementation I´m going to provide is a REST protocol. But I´m also considering Vertx and RabbitMQ just for the heck f it. My goal is to be that flexible.

Internally Seagull service to Seagull service should work exactly the same no matter the under-laying protocol.

SGServiceDirectory should lookup all locally available services on startup. Other service nodes on the network till be announced to all nodes with their source node. 

In general service calls will look for called service locally first , and if not found then an external services will be searched and called if found, Failure to find called service will fail with an exception. 
