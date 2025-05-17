package se.natusoft.seagull.api

import groovy.transform.CompileStatic
import se.natusoft.docutations.Many
import se.natusoft.lic.annotation.BinariesAvailableAt
import se.natusoft.lic.annotation.Human_Software_License_1_0
import se.natusoft.lic.annotation.SourceAvailableAt
import se.natusoft.seagull.SG_ID
import se.natusoft.seagull.api.model.SGMessage

@Human_Software_License_1_0
@SourceAvailableAt("https://github.com/tombensve/")
@BinariesAvailableAt("https://repo.repsy.io/mvn/tombensve/natusoft-os/")

/**
 * These implement a network protocol for calling services on the network.
 *
 * There can be many of these!
 */

@CompileStatic
@Many( "Minimum one protocol must be implemented and available in a jar!" )
interface SGProtocol {

    /**
     * All protocols should add themselves to this map.
     */
    static Map<String, SGProtocol> protocols = [ : ]

    /**
     * The name of the protocol, to be able to identify it!
     *
     * A protocol is unique specific thing! Do not add different implementations of same
     * protocol in same jar! If you do, it will be relatively random which is used!
     *
     * @return The name of the protocol.
     */
    String name()

    /**
     * Sends a message to a service using a specific protocol..
     *
     * @param The message to send.
     */
    void send( SG_ID target, SGMessage<?> data )

    /**
     * Registers a listener of received messages.
     *
     * @param listener The listener to be called when a message is received.
     *
     * @return An UUID representing this listener instance.
     */
    void registerListener( SG_ID service, Closure<SGMessage<?>> listener )

    /**
     * Use the UUID gotten at registration to stop listening to more messages.
     *
     * @param listener The listener UUID to unregister.
     */
    void unregisterListener( SG_ID listener )

    /**
     * Do a total cleanup.
     */
    void shutdown()

}
