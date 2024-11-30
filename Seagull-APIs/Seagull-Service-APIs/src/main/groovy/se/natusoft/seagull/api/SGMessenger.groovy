package se.natusoft.seagull.api

import groovy.transform.CompileStatic
import se.natusoft.lic.annotation.Apache_Software_License_2_0

/**
 * This is given to all services for communication.
 *
 * Note: Seagull only says that data sent or received should use JSON.
 *
 * I have decided to make this API as a message bus! This due to the flexibility
 * of such, and allow implementations to use buses also.
 *
 * Note however that Seagull can supply multiple communication protocols under
 * the surface, even Request / Response protocols. Seagull services should not
 * care about the network protocols! There must however be at least one
 * network protocol provider available!
 */

@CompileStatic

@Apache_Software_License_2_0
interface SGMessenger {

    static String BROADCAST = "*"

    /**
     * Calls a service.
     *
     * @param to The receiver of the message.
     * @param from Name of who is calling. Needed for eventual replies!
     * @param messageTypeName Identify content. This will have to be known by all parts.
     * @param message The message to send.
     */
    void send( String to, String from, String messageTypeName, SGJson message )

    /* _______________________________________________________________________________ */

    /**
     * Register to receive messages of a named type.
     *
     * NOTE: For protocols that returns a direct response for a request
     *       for example REST, that will also be delivered here! In such
     *       cases, register a receiver before sending anything!
     *
     * @param type The message type to receive.
     * @param handler A Closure to handle the received messages.
     */
    UUID registerReceiver(String messageType, Closure<SGJson> handler )

    /* _______________________________________________________________________________ */

    /**
     * Unregisters the receive of a message type.
     *
     * @param receiverId Stop receiving from this!
     */
    void unregisterReceiver( UUID receiverId )

}
