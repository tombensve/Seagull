package se.natusoft.seagull.api

import groovy.transform.CompileStatic
import se.natusoft.docutations.Many
import se.natusoft.lic.annotation.Apache_Software_License_2_0
import se.natusoft.seagull.api.model.SGMessage
/**
 * These implement a network protocol for calling services on the network.
 *
 * There can be many of these!
 */
@Apache_Software_License_2_0
@CompileStatic
@Many( "Minimum one!" )
interface SGProtocol {

    /**
     * The name of the protocol, to be able to identify it!
     *
     * @return The name of the protocol.
     */
    String protocolName()

    /**
     * Specifies the provider of the protocol. The idea behind providing this
     * is to be able to filter on this or not this if there are more protocols
     * implementing REST as a protocol available.
     *
     * This might however go away again since to not complicate things more than
     * needed it might not be a good idea to use this.
     */
    String protocolProvider()

    /**
     * Sends a message to a service using a specific protocol..
     *
     * @param The message to send.
     */
    void send( SGMessage<?> data )

    /**
     * Registers a listener of received messages.
     *
     * @param listener The listener to be called when a message is received.
     *
     * @return An UUID representing this listener instance.
     */
    UUID registerListener( Closure<SGMessage<?>> listener )

    /**
     * Use the UUID gotten at registration to stop listening to more messages.
     *
     * @param listener The listener UUID to unregister.
     */
    void unregisterListener( UUID listener )

    /**
     * Do a total cleanup.
     */
    void shutdown()

}
