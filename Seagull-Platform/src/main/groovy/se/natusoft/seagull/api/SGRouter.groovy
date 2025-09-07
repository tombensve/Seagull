package se.natusoft.seagull.api

import groovy.transform.CompileStatic
import se.natusoft.docutations.Single
import se.natusoft.lic.annotation.BinariesAvailableAt
import se.natusoft.lic.annotation.Human_Software_License_1_0
import se.natusoft.lic.annotation.SourceAvailableAt
import se.natusoft.seagull.api.model.SGMessage
import se.natusoft.seagull.tools.SGProviderLookup

@Human_Software_License_1_0
@SourceAvailableAt( "https://github.com/tombensve/" )
@BinariesAvailableAt( "https://repo.repsy.io/mvn/tombensve/natusoft-os/" )

/**
 * - Protocols calls SGRouter.
 * - Target of the message is available in local node:
 *   - Pass message to target.
 * else
 *   - forward message to node having target using internal TCP protocol.
 *
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *
 * SGRouter are called from Protocols to route messages to
 * correct service, and replies back to caller for 2 way protocols.
 * Some protocols will only receive messages, and if a response is
 * wanted they will sent a new response message that will be treated
 * as any message. This is handled by protocols. The router is only
 * responsible for forwarding messages to target receiver.
 */
@CompileStatic
@Single( "There is only one per Jar of of this!" )
interface SGRouter {
    
    static final SGRouter Router = SGProviderLookup.find( SGRouter.class )
    
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
    static String ID = UUID.randomUUID( ).toString( )
    
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ //
    
    /**
     * Routes an incoming message. This means that the message
     * should be forwarded to a service, and that the target service
     * might not be available on local node, in which case it need
     * to be forwarded to another node. In that case the message
     * needs to be forwarded to routeOutgoing(...)!
     *
     * @param message The incoming message to route.
     */
    void routeIncoming( SGMessage message )
    
    /**
     * Routes a message to valid service or a reply!
     * Do note that all messages have a common header that are
     * inherited that contains to and from information.
     *
     * @param message The message to route.
     */
    void routeOutgoing( SGMessage message )
    
    /**
     * Killer!
     */
    void shutdown()
    
}
