package se.natusoft.seagull.api

import groovy.transform.CompileStatic
import se.natusoft.docutations.Single
import se.natusoft.lic.annotation.Apache_Software_License_2_0
import se.natusoft.seagull.api.model.SGMessage
import se.natusoft.seagull.tools.SGAPIProvider
import se.natusoft.seagull.SGId

/**
 * This keeps track of all services and where they are available. In same jar, or on the network,
 * and if so where on the network. Jar package can contain multiple services, but should only
 * contain one SGRouter! The SGRouter in turn should make use of one or more SGProtocol to
 * communicate with outside world.
 *
 * It is also responsible for handling "SGId.Broadcast".
 *
 * There should be only one router per runnable Jar file!
 */
@Apache_Software_License_2_0
@CompileStatic
@Single
interface SGRouter {

    /**
     * The router instance.
     */
    static final SGRouter Router = SGAPIProvider.find( SGRouter.class )

    // ------------------------------------------------------------------------ //

    void registerService( SGId serviceId, SGService service )

    /**
     * Routes outgoing message.
     */
    void routeOutgoing( SGMessage<?> message )

    /**
     * Registers a listener for messages from a certain named source.
     *
     * @param from The source to receive messages from.
     * @param listener A closure to receive messages from the specified source.
     *
     * @return An UUID representing this listener. This should be used to
     *         unregister the listener later on.
     */
    UUID registerListener( Closure<SGMessage> message )


    /**
     * Unregisters a previously registered listener.
     *
     * @param from The id of the listener to unregister.
     */
    void unregisterListener( UUID listenerId )
}
