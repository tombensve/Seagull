# SG-Gson-Provider

This module / jar wraps the Google Gson library and provides functionality
to convert JSON to Map<String, Object> and to convert Map<String, Object> to JSON.

The thinking here is that no external library code should be used directly in
the main code, but wrapped as internal services that provide functionality from 
the library. This also makes it easier to see what library code is used.

All external library wrappers should wrap one and only one library! 

Seagull-Platform provides the service API interface to implement, thereby 
there is a dependency to that. 
