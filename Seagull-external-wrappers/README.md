
This is part of my "external wrapper" concept, where external libraries are not used
in internal code directly, but calls wanted functionality via "External Library Wrappers"
using interfaces . So code using these know nothing about the external library. They
just get calls to do what they need to do, without any knowledge of the actual provider,
which then is easily replaced without affecting any other code.

My goal is to treat most external libraries like this, and this will also make it
very clear what is actually used from an external library.

# SG-Gson-JSONMap-Provider

This module wraps the Google Gson library and provides functionality
to convert JSON to Map<String, Object> and to convert Map<String, Object> to JSON.

Do note that depending on what external library is used to provide HTTP/S
communication, this might not be needed. For example UnderTow provides both 
HTTP* communication and translating between JSON<->Map<String, Object>, in
which case this will not be needed.

In the end SeaGull service Jars will be executable with "java -jar MyServices.jar"

# SG-Webb-Server-Provider

This will provide an API to 
- send HTTP(S) with JSON messages.
- Receive HTTP(S) messages.
- Reply to received messages.
