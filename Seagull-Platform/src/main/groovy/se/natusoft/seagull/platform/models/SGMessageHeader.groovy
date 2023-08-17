package se.natusoft.seagull.platform.models

import groovy.transform.CompileStatic

/**
 * Modelish model representing message header for senders and receivers.
 */
@CompileStatic
interface SGMessageHeader extends SGInternalMessageHeader {

    /**
     * @param targets The name of a service to receive the message, or a comma separated (no spaces)
     *                list of services to receive the message.
     *
     * @return this.
     */
    SGMessageHeader setTargets(String targets)

    String getTargets()

    /**
     * If true then all instances found of the target service will be called.
     * Otherwise if the target is available locally in same jar file it will
     * be called, otherwise one of the remotely available service instances
     * will be called.
     *
     * @param broadcast true or false. Defaults to false.
     *
     * @return this.
     */
    SGMessageHeader setBroadcast(boolean broadcast)

    boolean isBroadcast()

    /**
     * Provides who is sending message. Can be used for direct replies.
     *
     * @param sender The unique ID of the sender
     *
     * @return this.
     */
    SGMessageHeader setSender(String sender)

    String getSender()

}
