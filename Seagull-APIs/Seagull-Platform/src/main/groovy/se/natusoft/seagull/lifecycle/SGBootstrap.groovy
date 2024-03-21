package se.natusoft.seagull.lifecycle

import se.natusoft.seagull.platform.SGRouter
import se.natusoft.seagull.platform.SGService
import se.natusoft.seagull.platform.loaders.SGAPILoader

/**
 * This boots up an instance of Seagull!
 *
 * What happens here depends on what SGService instances are included in the jar file!
 *
 * There can be one per runnable, or there can be many in same! When available in same
 * that service will always be called in local package. Only when not found locally will
 * it go out on the network and do a network call.
 */
class SGBootstrap {

    // There should only be one SGRouter available per jar file!!
    private static SGRouter router = SGAPILoader.find( SGRouter )

    static void main( String[] args ) {
        startup()
    }

    // DO NOTE: What services you get locally depends entirely on which such is
    // included in jar file! There should be at least one!
    //
    // Any service not found locally will be expected to be available on network.
    // The router will manage all this!

    /**
     * Called on startup!
     *
     * @param store A Map in which data can be stored while running.
     */
    static void startup() {

        router.startup()

        SGAPILoader.findAll( SGService.class ).each { SGService service ->
            service.startup( router )
        }
    }

    /**
     * Called to shut down.
     *
     * @param store Same Map as passed to startup.
     */
    static void shutdown() {

        SGAPILoader.findAll( SGService.class ).each { SGService service ->
            service.shutdown( router )
        }

        router.shutdown()
    }
}
