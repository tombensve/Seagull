package se.natusoft.seagull.platform

import groovy.transform.CompileStatic
import se.natusoft.seagull.platform.models.SGServiceCall
import se.natusoft.seagull.platform.models.SGServiceReg

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
interface SGPlatformInteraction {

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
