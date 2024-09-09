package se.natusoft.seagull.api

/**
 * Defines a protocol for communication over the network or whatever transport is is used.
 *
 * I might be completely nuts, but I've always have thought that communication between 2
 * computers in different places over a carrier pigeon transport would be really cool!
 */
interface SGProtocol extends SGComm {

    /**
     * 2 parts need to use the same protocol to talk. Seagull supports having
     * more than one protocol.
     *
     * @return The name of the protocol. Examples: "REST" "XML"
     */
    String getProtocol()

}
