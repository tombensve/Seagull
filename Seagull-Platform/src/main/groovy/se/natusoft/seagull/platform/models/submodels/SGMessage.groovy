package se.natusoft.seagull.platform.models.submodels

import groovy.transform.CompileStatic
import se.natusoft.seagull.platform.tools.SGJson

/*
 * This file contains all models part of the basic message request.
 */

/**
 * This represents a Seagull message.
 */
interface SGMessage {

    /**
     * Provides meta data for the message.
     *
     * @param sgMeta The meta data to provide.
     *
     * @return self.
     */
    SGMessage setSgMeta(SGMeta sgMeta)

    /**
     * @return The meta data of the message.
     */
    SGMeta getSgMeta()

    /**
     * Provides the actual message data.
     *
     * @param message The message to send.
     *
     * @return self.
     */
    SGMessage setMessage(SGJson message)

    /**
     * @return The message content.
     */
    SGJson getMessage()

    /**
     * Sets an error message.
     *
     * @param errorMessage The error message.
     * @return
     */
    SGMessage setError(String errorMessage)

    /**
     * @return error message.
     */
    String getError()
}

/**
 * Identification of a service.
 */
@CompileStatic
interface SGServiceId {

    /**
     * Sets the unique id of the service. Consider using UUID.
     *
     * @param id The id to set.
     *
     * @return self.
     */
    SGServiceId setServiceId(String id)

    String getServiceId()

    /**
     * Sets the name of the service.
     *
     * @param name The name to set.
     * @return self.
     */
    SGServiceId setServiceName(String name)

    String getServiceName()

}

/**
 * This is a serviceId with the additional flag of sending to all instances of the
 * service found.
 */
@CompileStatic
interface SGServiceTarget extends SGServiceId {

    /**
     * If this is true then message will be sent to all instances of specified service.
     * Is thereby only relevant for "to".
     *
     * @param toAll true/false
     *
     * @return self.
     */
    SGServiceId setToAll(boolean toAll)

    boolean getToAll()
}

/**
 * Action of request. This to be compatible with REST even though from a service provider
 * or service callers perspective it isn't. Seagull tries to not say anything about how
 * services communicate from an API perspective.
 */
@CompileStatic
enum SGAction {
    Create, Update, Delete, Get
}

/**
 * This is always included with all messages.
 */
@CompileStatic
interface SGMeta {

    /**
     * Specifies the version of the current protocol. This to make future versions
     * be able to identify and handle older messages.
     *
     * @param messageProtocolVersion The current version used.
     *
     * @return self.
     */
    SGMeta setProtocolVersion(float protocolVersion)

    /**
     * @return current protocol version.
     */
    float getProtocolVersion()

    /**
     * The target for this message.
     *
     * @param serviceTarget The id of the service to receive the message and an optional
     *                      flag of sending to all instances of named service id, i.e a
     *                      broadcast.
     *
     * @return self
     */
    SGMeta setTo(SGServiceTarget serviceTarget)

    /**
     * Used by platform to determine to where the message should be delivered.
     *
     * @return the id of the target.
     */
    SGServiceTarget getTo()

    /**
     * @param serviceId The id of the sender of message. Can be used for replies.
     *
     * @return self
     */
    SGMeta setFrom(SGServiceId serviceId)

    /**
     *
     * @return the service identifier of the originating service.
     */
    SGServiceId getFrom()

    /**
     * The action to perform.
     *
     * @param action The action to perform by target service.
     *
     * @return self.
     */
    SGMeta setAction(SGAction action)

    /**
     * @return The wanted action.
     */
    SGAction getAction()
}
