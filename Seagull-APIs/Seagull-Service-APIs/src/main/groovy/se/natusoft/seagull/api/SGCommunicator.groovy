package se.natusoft.seagull.platform

import se.natusoft.seagull.api.SGJson

/**
 * This is given to all services for communication.
 *
 * Note that Seagull only says that data sent or received should use JSON.
 * Different messages are only named as a String! Both sides need to know
 * what that is by the name. There is no structure validation what so ever!
 */
interface SGCommunicator {

    /**
     * Sends a message.
     *
     * @param to The service to communicate with. Should be its name!
     * @param from Name of who is sending message. Needed only for eventual replies!
     * @param messageType Names the type of the message. Both sides need to be
     *                    aware of what this is, how to read and write it!
     * @param message The message to send.
     */
    void send( String to, String from, String messageType, SGJson message )

    /**
     * Register to receive messages of a named type.
     *
     * @param messageType The type name of the message to receive.
     * @param receiver A Closure to receive the message.
     */
    void registerListener( String messageType, Closure<SGJson> receiver )

    /**
     * Unregisters the receive of a message type.
     *
     * @param messageType The message type to no longer receive messages about.
     */
    void unregisterListener( String messageType )
}
