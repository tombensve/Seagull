package se.natusoft.seagull.api

import groovy.transform.CompileStatic
import se.natusoft.docutations.Many
import se.natusoft.lic.annotation.Apache_Software_License_2_0
import se.natusoft.seagull.api.model.SGMessage
import se.natusoft.seagull.SGId

/**
 * These implement a network protocol for calling services on the network.
 *
 * There can be many of these!
 */
@Apache_Software_License_2_0
@CompileStatic
@Many
interface SGProtocol {

    /**
     * The name of the protocol, to be able to identify it!
     *
     * @return The name of the protocol.
     */
    String protocolName()

    /**
     * Sends a message to a service using a specific protocol..
     *
     * @param The message to send.
     */
    void send( SGMessage<?> data )

    /**
     * Registers a listener of received messages.
     *
     * @param from Listen to messages from this sGId.
     * @param listener The listener to be called when a message is received.
     *
     * @return An UUID representing this listener instance.
     */
    UUID registerListener( SGId from, Closure<SGMessage<?>> listener )

    /**
     * Use the UUID gotten at registration to stop listening to more messages.
     *
     * @param listener The listener UUID to unregister.
     */
    void unregisterListener( UUID listener )

}
