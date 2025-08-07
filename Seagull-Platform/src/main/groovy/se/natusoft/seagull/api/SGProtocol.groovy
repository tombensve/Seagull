package se.natusoft.seagull.api

import groovy.transform.CompileStatic
import se.natusoft.docutations.Many
import se.natusoft.lic.annotation.BinariesAvailableAt
import se.natusoft.lic.annotation.Human_Software_License_1_0
import se.natusoft.lic.annotation.SourceAvailableAt
import se.natusoft.seagull.SGID
import se.natusoft.seagull.api.model.SGMessage
import se.natusoft.seagull.exceptions.SGNotFoundException
import se.natusoft.seagull.tools.SGAPILookup

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
    static List<SGProtocol> AvailableProtocols = SGAPILookup.findAll( SGProtocol.class )

    /**
     * The name of the protocol, to be able to identify it!
     *
     * @return The name of the protocol.
     */
    String getName()

    /**
     * Sends a message to a service using a specific protocol..
     *
     * @target The target to send to.
     * @param message The message to send.
     */
    void send( SGID target, SGMessage<?> message ) throws SGNotFoundException

    /**
     * Registers a receiver of messages.
     *
     * @param service The SGID of the service to receive messages from.
     * @param receiver The receiver to be called when a message is recived.
     *
     * @return An SGID representing this receiver instance.
     */
    void registerReceiver( SGID service, Closure<SGMessage<?>> receiver )

    /**
     * Use the SGID gotten at registration to stop listening to more messages.
     *
     * @param service The listener UUID to unregister.
     */
    void unregisterReceiver( SGID service )

    /**
     * Announce unavailability and then shut down.
     */
    void shutdown()
    
    

}
