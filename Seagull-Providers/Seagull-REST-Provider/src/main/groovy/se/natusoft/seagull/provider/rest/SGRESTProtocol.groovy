package se.natusoft.seagull.provider.rest

import se.natusoft.seagull.SGId
import se.natusoft.seagull.api.SGProtocol
import se.natusoft.seagull.api.model.SGMessage

class SGRESTProtocol implements SGProtocol {

    /**
     * The name of the protocol, to be able to identify it!
     *
     * @return The name of the protocol.
     */
    @Override
    String protocolName() {
        return "SG-REST"
    }

    /**
     * Sends a message to a service using a specific protocol..
     *
     * @param The message to send.
     */
    @Override
    void send( SGMessage<?> data ) {

    }

    /**
     * Registers a listener of received messages.
     *
     * @param from Listen to messages from this sGId.
     * @param listener The listener to be called when a message is received.
     *
     * @return An UUID representing this listener instance.
     */
    @Override
    UUID registerListener( SGId from, Closure<SGMessage<?>> listener ) {
        return null
    }

    /**
     * Use the UUID gotten at registration to stop listening to more messages.
     *
     * @param listener The listener UUID to unregister.
     */
    @Override
    void unregisterListener( UUID listener ) {

    }
}
