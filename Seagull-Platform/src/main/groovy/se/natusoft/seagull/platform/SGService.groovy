package se.natusoft.seagull.platform

import groovy.transform.CompileStatic

/**
 * Defines the minimum required API of a Seagull service.
 */
@CompileStatic
interface SGService {

    /**
     * Initializes the service and provides objects it needs. Called on startup.
     *
     * @param sender For sending messages. Should be saved locally.
     */
    void startService(SGMessenger messenger)

    /**
     * Stops the service. Called on shutdown.
     */
    void shutdownService()

    /**
     * @return Meta data about the service.
     */
    SGJson getServiceMetadata()
}

