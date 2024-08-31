# Groovy REST options

[HTTPBuilder](https://marketsplash.com/tutorials/groovy/groovy-rest/)

[http-builder-ng](https://http-builder-ng.github.io/http-builder-ng/) *

# mdns

[jmdns](https://github.com/jmdns/jmdns)

-------------------------------------------------------------------

Native Groovy GET and POST
// GET
def get = new URL("https://httpbin.org/get").openConnection();
def getRC = get.getResponseCode();
println(getRC);
if(getRC.equals(200)) {
println(get.getInputStream().getText());
}

// POST
def post = new URL("https://httpbin.org/post").openConnection();
def message = '{"message":"this is a message"}'
post.setRequestMethod("POST")
post.setDoOutput(true)
post.setRequestProperty("Content-Type", "application/json")
post.getOutputStream().write(message.getBytes("UTF-8"));
def postRC = post.getResponseCode();
println(postRC);
if(postRC.equals(200)) {
println(post.getInputStream().getText());
}
--Jim Perris

-------------------------------------------------------------------

Groovy map to json list of objects
http://stackoverflow.com/questions/51068636/ddg#51069031
to serialize map to json object (string)
you can use
http://docs.groovy-lang.org/latest/html/gapi/groovy/json/JsonBuilder.html
import groovy.json.JsonBuilder
new JsonBuilder([test: 'test', test2: 'test2']).toPrettyString()
or
http://docs.groovy-lang.org/latest/html/gapi/groovy/json/JsonOutput.html
import groovy.json.JsonOutput
JsonOutput.prettyPrint(JsonOutput.toJson([test: 'test', test2: 'test2']))
--daggett

-------------------------------------------------------------------

https://stackoverflow.com/questions/53698518/groovy-convert-string-map-to-jsonobject
