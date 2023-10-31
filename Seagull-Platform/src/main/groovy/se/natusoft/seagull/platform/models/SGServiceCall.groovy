package se.natusoft.seagull.platform.models

import groovy.transform.CompileStatic
import se.natusoft.seagull.platform.SGJson
import se.natusoft.tools.modelish.Cloneable

/**
 * Modelish model representing data needed to call a service.
 */
@CompileStatic
interface SGServiceCall extends Cloneable<SGServiceCall> {

    /** Sets the name of the service to call. */
    SGServiceCall setServiceName(String name)

    /** Gets the name of the service to call. */
    String getServiceName()

    /** Sets the minimum version of the service to call. */
    SGServiceCall setMinimumVersion(float version)

    /** Gets the minimum version of the service to call. */
    float getMinimumVersion()

    /** Sets the preferred version of the service to call. */
    SGServiceCall setPreferredVersion(float version)

    /** Gets the preferred version of the service to call. */
    float getPreferredVersion()

    /** Sets a JSON document to pass to the service. The service called defines what that should be. */
    SGServiceCall setCallData(SGJson callSata)

    /** Returns the JSON document passed by a client. */
    SGJson getCallData()

    /** If set to true then the call will be passed to all instances of matching services found.
     If false only one will be called, but if there are more than one available, it is undetermined
     which one will be called. Callers should not care, since they have no say in this.
     Note that all implementations might not support this! But you should always set this when
     doing a call.
     */
    SGServiceCall setBroadcast(boolean broadCast)

    /** Returns the broadcast state. */
    boolean getBroadcast()
}