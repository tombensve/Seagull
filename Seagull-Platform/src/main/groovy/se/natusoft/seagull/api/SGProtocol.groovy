package se.natusoft.seagull.api

import groovy.transform.CompileStatic
import se.natusoft.docutations.Many
import se.natusoft.lic.annotation.BinariesAvailableAt
import se.natusoft.lic.annotation.Human_Software_License_1_0
import se.natusoft.lic.annotation.SourceAvailableAt
import se.natusoft.seagull.SGID
import se.natusoft.seagull.api.model.SGMessage
import se.natusoft.seagull.tools.SGAPIProvider

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
     * This contains a list of all protocol implementations found on classpath (JAR).
     */
    static List<SGProtocol> protocols = SGAPIProvider.findAll( SGProtocol.class )

    /**
     * The name of the protocol, to be able to identify it!
     *
     * @return The name of the protocol.
     */
    String name()

    /**
     * Sends a message to a service using a specific protocol..
     *
     * @param The message to send.
     */
    void send( SGID target, SGMessage<?> data )

    /**
     * Registers a listener of received messages.
     *
     * @param listener The listener to be called when a message is received.
     *
     * @return An UUID representing this listener instance.
     */
    void registerListener( SGID service, Closure<SGMessage<?>> listener )

    /**
     * Use the UUID gotten at registration to stop listening to more messages.
     *
     * @param listener The listener UUID to unregister.
     */
    void unregisterListener( SGID listener )

    /**
     * Announce unavailability and then shut down.
     */
    void shutdown()

}
