package se.natusoft.seagull.api

import groovy.transform.CompileStatic
import se.natusoft.docutations.Many
import se.natusoft.lic.annotation.BinariesAvailableAt
import se.natusoft.lic.annotation.Human_Software_License_1_0
import se.natusoft.lic.annotation.SourceAvailableAt
import se.natusoft.seagull.SGID
import se.natusoft.seagull.api.model.SGMessage
import se.natusoft.seagull.exceptions.SGNotFoundException
import se.natusoft.seagull.tools.SGProviderLookup

@Human_Software_License_1_0
@SourceAvailableAt( "https://github.com/tombensve/Seagull" )
@BinariesAvailableAt( "https://repo.repsy.io/mvn/tombensve/natusoft-os/" )

//.....................................................................................//

/**
 * These implement a network protocol for calling services on the network.
 *
 * There can be many of these!
 */
@CompileStatic
@Many( "Minimum one protocol must be implemented and available in a jar!" )
interface SGProtocol {
    
    /**
     * This contains a list of all protocol implementations found on classpath (JAR).
     */
    static List<SGProtocol> AvailableProtocols =
            SGProviderLookup.findAll( SGProtocol.class )
    
    //........................................... ......................................//
    
    /**
     * @return The type of the protocol. Example "REST", "Plain TCP", "Morse code",
     * "Carrier Pigeon".
     */
    String getType()
    
    //.................................................................................//
    
    /**
     * @return the name of the provider. Example: "Seagull", which indicates a default
     *  implementation provided by Seagull. This is meta data that can be useful when
     *  trouble shooting.
     */
    String getProviderName()
    
    //.................................................................................//
    
    /**
     * Sends a message to a service using a specific protocol.
     *
     * Do note:
     *   - that the target of the message are provided within the message!
     *   - that received messages should be passed to the SGRouter which will
     *     - convert received data to a SGMessage instance.
     *     - route them to a matching service or services.
     *     - Possibly forward to another router on another node.
     *   - The target can also be a broadcast target!
     *
     * @param message The message to send.
     */
    void send( SGMessage message ) throws SGNotFoundException
    
    //.................................................................................//
    
    /**
     * Registers a receiver that will provide a Closure to receive and handle messages.
     *
     * @param receiverId A Unique SGID representing the receiver.
     * @param receiver The actual Closure to call with received messages.
     */
    void registerReceiver( SGID receiverId, Closure<SGMessage> receiver )
    
    //.................................................................................//
    
    /**
     * Removes a previously registered Closure from being called again.
     *
     * @param receiverId The SGID of the receiver.
     */
    void unregisterReceiver( SGID receiverId )
    
    //.................................................................................//
    
    /**
     * Announce unavailability and then shut down.
     */
    void shutdown()
    
}
