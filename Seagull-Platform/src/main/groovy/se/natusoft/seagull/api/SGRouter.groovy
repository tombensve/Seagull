package se.natusoft.seagull.api

import groovy.transform.CompileStatic
import se.natusoft.docutations.Single
import se.natusoft.lic.annotation.BinariesAvailableAt
import se.natusoft.lic.annotation.Human_Software_License_1_0
import se.natusoft.lic.annotation.SourceAvailableAt
import se.natusoft.seagull.SG_ID
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
 * - Use SGProtocol to send messages.
 * - Use SGProtocol to receive messages.
 *
 * SGRouter:s should also multicast themselves on the network!
 *
 * There should be only one router per runnable Jar file!
 */
@CompileStatic
@Single( "Uses one or more protocols to communicate." )
interface SGRouter {

    /**
     * The router instance.
     */
    @Single( "Should only be one of these in a jar!" )
    static final SGRouter router = SGAPIProvider.find( SGRouter.class )

    // ------------------------------------------------------------------------ //

    /**
     * Registers a service with the router.
     *
     * @param serviceId The id of the service.
     * @param sgService service to register,
     */
    registerLocalService( SG_ID serviceID, SGService sgService )

    /**
     * Sync with available remote services on the network.
     */
    syncWithAvailableRemoteServices()

    /**
     * Sends a message to a service, either locally or on the network.
     *
     * @param target
     * @param message
     */
    void sendMessage( SG_ID service, SGMessage message )

    /**
     * This will send message to all message receivers.
     *
     * @param from Who is sending.
     * @param message The message to broadcast.
     */
    void broadcast( SG_ID from, SGMessage message )

    /**
     * Cleanup and shut down.
     */
    void shutdown()


}
