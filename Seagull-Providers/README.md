# Seagull Providers

These are implementations of different Seagull APIs.

There is nothing that says that these must be used! Anyone can provide an
implementation of the APIs in Seagull-Platform. These are just default providers,
that **can** be used. These are also used for testing. 

Do note that there are two types of "internal" APIs!

- **Communication protocol providers**  Ex: Seagull-REST-Protocol-Provider.

- **Internal functionality provided by wrappers of external libraries**, providing just the functionality needed / used. Internal code does not just access external libraries directly. A Service API is defined for the wanted functionality, and then an implementation is provided using the external library. Internally the code will have no knowledge of what is used to implement this functionality, and should not care. The external library can be replaced with any implementation that provides the wanted functionality without any dependency on a specific library within internal code.    
