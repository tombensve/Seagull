# SeaGull Design

This project aims at proving a service API based on sending merssages, but not demanding any specific protoccol. The protocol depends entirely on the implementation. 

The first implementation I´m going to provide will use REST. But I´m also considering Vertx and RabbitMQ just for the heck f it. 

Internally Segull service to Seagull service should work exactly the same no matter the underlaying protocol.

Allavailable services should be registered with a Seagull router, which will be done on startup.





