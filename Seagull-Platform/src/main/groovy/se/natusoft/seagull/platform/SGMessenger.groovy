package se.natusoft.seagull.platform

import groovy.transform.CompileStatic
import se.natusoft.seagull.platform.tools.SGJson

/**
 * Used to communicate with others.
 */
@CompileStatic
interface SGMessenger {

    // The idea that messages can just be send and if a reply is needed it will come
    // back as a separate message causes complications!
    // I like the idea of things being truly reactive, but in the end these will
    // be REST services! That means a response!

    //

    // - Use Undertow for receiving messages and some good client for sending them.
    //
    // - Don't reply to messages! If you have a reply send it as new message to
    //   either sender, or some other service and so forth. In the end some
    //   service will call originator back with something it wants, but it will
    //   react on received message when such comes, not wait for a reply to request.
    //   It will be very reactive!
    //
    // - We send messages with http/https for simplicity!
    //
    // - This only when needing to send over network. If receiving service is bundled in
    //   same jar as sender there will be no http/https communication at all.

    /**
     * Each service receives an instance of this.
     *
     * @param messageType A named message type provided in message header.
     * @param A message receiving closure.
     */
    void registerMessageListener(String messageType, Closure<SGJson> messageListener)

    void sendMessage(SGJson message)

    void sendMessageToAll(SGJson message)
}
