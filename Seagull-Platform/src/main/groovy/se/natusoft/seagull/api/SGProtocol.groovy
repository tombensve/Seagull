package se.natusoft.seagull.api

import groovy.transform.CompileStatic
import se.natusoft.docutations.Many
import se.natusoft.lic.annotation.BinariesAvailableAt
import se.natusoft.lic.annotation.Human_Software_License_1_0
import se.natusoft.lic.annotation.SourceAvailableAt
import se.natusoft.seagull.SGID
import se.natusoft.seagull.api.model.SGMessage
import se.natusoft.seagull.exceptions.SGNotFoundException
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
    static List<SGProtocol> AvailableProtocols = SGAPIProvider.findAll( SGProtocol.class )

    /**
     * The name of the protocol, to be able to identify it!
     *
     * @return The name of the protocol.
     */
    String getName()

    /**
     * Sends a message to a service using a specific protocol..
     *
     * @param The message to send.
     */
    void send( SGID target, SGMessage<?> data ) throws SGNotFoundException

    /**
     * Registers a receiver of messages.
     *
     * @param service The service to receive messages from.
     * @param receiver The receiver to be called when a message is received.
     *
     * @return An UUID representing this receiver instance.
     */
    void startReceiving( SGID service, Closure<SGMessage<?>> receiver )

    /**
     * Use the UUID gotten at registration to stop listening to more messages.
     *
     * @param listener The listener UUID to unregister.
     */
    void stopReceiving( SGID listener )

    /**
     * Announce unavailability and then shut down.
     */
    void shutdown()

}
