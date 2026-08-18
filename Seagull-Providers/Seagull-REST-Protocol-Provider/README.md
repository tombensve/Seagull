# Seagull REST protocol provider

Note that in this case I'll import UnderTow library directly in this
module and not wrap in Seagull-external-wrappers. This because there
is a big diff between this and that.

This functionality is specific for providing HTTP communication for talking
REST. This is an internal dependency for this provider. The SG-JSONMapConverter
however provides functionality that can be of use for other protocol
providers. I have decided to make JSON a standard format for exchanging
data independent of protocol. If some protocol requires data in other
format then the protocol provider have to translate between JSON and
whatever. At Seagull level Modelish models are used, and whatever
format is required by receiver have to be handled internally in provider.

Internally in Seagull all data is stored in Modelish models, which
internally is stored in HashMaps, which basically are JSON structures. 
