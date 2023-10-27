package se.natusoft.seagull.platform

import groovy.transform.CompileStatic
import se.natusoft.tools.modelish.Cloneable
import se.natusoft.tools.modelish.Modelish

/**
 * Modelish model representing a specific service registration.
 *
 * Created like this: SgServiceReg sgSvcReg = Modelish.create(ShServiceReg.class).serviceName("qaz")...
 */
interface SGServiceReg extends Cloneable<SGServiceReg> {

    /** Sets name of the service */
    SGServiceReg serviceName(String name)

    /** Gets the name of the service. */
    String serviceName()

    /** sets the version of the service. */
    SGServiceReg serviceVersion(float serviceVersion)

    /** Gets the name of the service. */
    float serviceVersion()

    /** Sets the backwards compatible flag of the service. */
    SGServiceReg backwardsCompatible(boolean backwardsCompatible)

    /** Returns the backwards compatible flag of the service. */
    boolean backwardsCompatible()
}

/**
 * Modelish model representing data needed to call a service.
 */
interface SGServiceCall extends Cloneable<SGServiceCall> {

    /** Sets the name of the service to call. */
    SGServiceCall serviceName(String name)

    /** Gets the name of the service to call. */
    String serviceName()

    /** Sets the minimum version of the service to call. */
    SGServiceCall minimumVersion(float version)

    /** Gets the minimum version of the service to call. */
    float minimumVersion()

    /** Sets the preferred version of the service to call. */
    SGServiceCall preferredVersion(float version)

    /** Gets the preferred version of the service to call. */
    float preferredVersion()

    /** Sets a JSON document to pass to the service. The service called defines what that should be. */
    SGServiceCall callData(SGJson callSata)

    /** Returns the JSON document passed by a client. */
    SGJson callData()

    /** If set to true then the call will be passed to all instances of matching services found.
     If false only one will be called, but if there are more than one available, it is undetermined
     which one will be called. Callers should not care, since they have no say in this.
     Note that all implementations might not support this! But you should always set this when
     doing a call.
     */
    SGServiceCall broadcast(boolean broadCast)

    /** Returns the broadcast state. */
    boolean broadcast()
}

/**
 * Utility for creating argument models. Let any class using this implement this trait.
 */
trait SGInteractionFactory {

    static SGServiceReg newSGServiceReg() {
        Modelish.create(SGServiceReg.class)
    }

    static SGServiceCall newSGServiceCall() {
        Modelish.create(SGServiceCall.class)
    }
}

// ----------------------------------------------------------------------------------------------- //

/**
 * <p>
 *   This is an API for each Seagull service to use for providing service and for
 *   calling other services. Its intent is to be as easy/trivial as possible!
 *   That is, there is not a ton of options!
 * </p>
 * <p>
 *   An instance of an implementation of this will be provided to each SGService implementation.
 * </p>
 */
@CompileStatic
interface SGInteraction {

    /**
     * This should be used to provide a service.
     *
     * @param serviceName Name of service to register.
     * @param version The version of the service. Different versions can co-exist.
     * @param backwardsCompatible true if current version is backwards compatible.
     *        You should always strive for being backwards compatible. This is for
     *        cases where that is not possible.
     * @param handler
     */
    void registerService(
            SGServiceReg sgServiceReg,
            Closure<SGServiceReg> handler
    )

    /**
     * Unregisters a service from being available.
     *
     * @param serviceReg The same SGServiceReg passed to registerService(...).
     */
    void unregisterService(
            SGServiceReg serviceReg
    )

    /**
     * Calls a service
     *
     * @param sgServiceCall Data for the service call.
     */
    void callService(SGServiceCall sgServiceCall)
}
