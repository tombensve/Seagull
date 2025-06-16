package se.natusoft.seagull.api

import groovy.transform.CompileStatic
import se.natusoft.docutations.Single
import se.natusoft.lic.annotation.BinariesAvailableAt
import se.natusoft.lic.annotation.Human_Software_License_1_0
import se.natusoft.lic.annotation.SourceAvailableAt
import se.natusoft.seagull.SGID
import se.natusoft.seagull.api.model.SGMessage
import se.natusoft.seagull.tools.SGAPIProvider

@Human_Software_License_1_0
@SourceAvailableAt( "https://github.com/tombensve/" )
@BinariesAvailableAt( "https://repo.repsy.io/mvn/tombensve/natusoft-os/" )

/**
 * This keeps track of all services and where they are available. In same jar, or on the network,
 * and if so where on the network. Jar package can contain multiple services, but should only
 * contain one SGRouter! The SGRouter in turn should make use of one or more SGProtocol to
 * communicate with outside world, and the inside world too!
 *
 * It is the routers job to:
 * - Lookup all available protocols bundled in jar file using SGAPIProvider.findAll( SGProtocol.class )
 * - Use SGProtocol to send messages.
 * - Use SGProtocol to receive messages.
 * - Automatically find available services bundled in jar file by using SGAPIProvider.find(SGService.class).
 *
 * SGRouter:s should also multicast themselves on the network!
 *
 * There should be only one router per runnable Jar file!
 */
@CompileStatic
@Single( "Uses one or more protocols to communicate." )
interface SGMessageRouter {

    /**
     * The router instance.
     */
    @Single( "Should only be one of these in a jar!" )
    static final SGMessageRouter messageRouter = SGAPIProvider.find( SGMessageRouter.class )

    // ------------------------------------------------------------------------ //

    /**
     * Routes a message to valid service
     *
     * @param sender of message.
     * @param receiver of message. Can also be SGID.Broadcast!
     * @param message
     */
    void sendMessage( SGID sender, SGID receiver, SGMessage message )

    /**
     * Registers a receiver of messages that needs to be routed to correct service
     * being called.
     *
     * @param service SGID of the service. Each service should have a unique SGID.
     * @param listener A Closure that takes an SGMessage.
     */
    void registerReceiver( SGID service, Closure<SGMessage<?>> listener )

    /**
     * Cleanup and shut down.
     */
    void shutdown()

}
