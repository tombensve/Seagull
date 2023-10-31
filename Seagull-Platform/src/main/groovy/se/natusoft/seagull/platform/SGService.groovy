package se.natusoft.seagull.platform

import groovy.transform.CompileStatic

/**
 * Each Seagull "service" will implement this interface and it should be annotated with
 * googles @AutoService, unless you prefer doing it the hard way ...
 *
 * To be very clear, each Seagull service provider will implement this interface
 * and receive the SGServiceInteraction which it will use to register and unregister
 * services.
 */
@CompileStatic
interface SGService {

    /**
     * Initializes the service and provides objects it needs. Called on startup and shutdown.
     *
     * @param sgInteraction Used to call services and receive calls for service providers.
     *        This should thereby be cached locally.
     */
    void start(SGPlatformInteraction sgInteraction)

    /**
     * Called on shutdown. Any needed cleanup should be done here.
     */
    void shutdown()

}
