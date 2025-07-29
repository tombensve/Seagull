# SG-Gson-JSON-Provider

This module wraps the Google Gson library and provides functionality
to convert JSON to Map<String, Object> and to convert Map<String, Object> to JSON.

Do note that depending on what external library is used to provide HTTP/S
communication, this might not be needed. For example UnderTow provides both 
HTTP* communication and translating between JSON<->Map<String, Object>, in
which case this will not be needed.

In the end SeaGull Jars will be executable with "java -jar MyService.jar"