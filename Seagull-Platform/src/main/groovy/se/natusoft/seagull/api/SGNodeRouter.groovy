package se.natusoft.seagull.api

import groovy.transform.CompileStatic
import se.natusoft.docutations.Single
import se.natusoft.lic.annotation.BinariesAvailableAt
import se.natusoft.lic.annotation.Human_Software_License_1_0
import se.natusoft.lic.annotation.SourceAvailableAt
import se.natusoft.seagull.SGID
import se.natusoft.seagull.api.model.SGMessage
import se.natusoft.seagull.tools.SGAPILookup

@Human_Software_License_1_0
@SourceAvailableAt( "https://github.com/tombensve/" )
@BinariesAvailableAt( "https://repo.repsy.io/mvn/tombensve/natusoft-os/" )

/**
 * Flow:
 *    Service call -> Protocol -> SGNodeRouter -> Service provider
 *    Service Provider -> SGNodeRouter -> Protocol -> Service reply
 * *
 * This keeps track of all services and where they are available. In same jar, or on the network,
 * and if so where on the network. Jar package can contain multiple services, but should only
 * contain one SGRouter! The SGRouter in turn should make use of one or more SGProtocol to
 * communicate with outside world, and the inside world too!
 *
 * There should be only one router per runnable Jar file!
 * Routers need some way to find each other, either through configuration or some multicast.
 * Maybe MDNS can be used ?
 *
 * As an alternative to a solution as MDNS I'm considering a plain router jar with
 * a configuration pointing out port it is running at. All jars with services
 * registers with this router and will receive updates of all services it knows about.
 *
 * This way only the "main" router will need a known port and hostname.
 */
@CompileStatic
@Single( "There is only one per Jar of of this class!" )
interface SGNodeRouter {
    
    static final SGNodeRouter Router = SGAPILookup.find( SGNodeRouter.class )
    
    /**
     * This should be unique! That said:
     *
     * - This field is not final!
     * - This field is a string and can be changed by implementations!
     * - By default a random UUID in String format is generated.
     * - The Java UUID is not guaranteed to generate a unique id,
     *   but highly likely will! But just in case you can replace the
     *   defaults with own values. This is static and public ...
     */
     public static String ID = UUID.randomUUID(  ).toString(  )
    // I know "public" is default in Groovy! Just want to be very clear!
    
    // ------------------------------------------------------------------------ //

    /**
     * Routes a message to valid service
     *
     * @param sender of message.
     * @param receiver of message. Can also be SGID.Broadcast!
     * @param message
     */
    void routeMessage( SGMessage message )

    /**
     * Registers a receiver of messages that needs to be routed to correct service
     * being called.
     *
     * @param service SGID of the service. Each service should have a unique SGID.
     * @param listener A Closure that takes an SGMessage.
     */
    void registerMessageReceiver( SGID service, Closure<SGMessage<?>> receiver )
    
    /**
     * Removes a receiver from receiving messages.
     *
     * @param SGID The ID of the service to unregister!
     */
    void unregisterMessageReceiver( SGID )

    /**
     * Cleanup and shut down.
     */
    void shutdown()

}
