package se.natusoft.seagull.api


/**
 * This represents a service. It is  fully possible to provide multiple services in same here!
 * It is entirely up to the developer to register several services or just one per SGService!
 *
 * Do note however that it might be more flexible to only have one per SGService.
 */
interface SGService {

    /**
     * Register service / services here.
     *
     * @param messenger Use this to interact with the service framework. i.e save it!!
     */
    void startup( SGMessenger messenger )

    /**
     * This is basically an order to shutdown services and do any other potential cleanup!
     *
     * Do return true if all went well! On any serious failures, log them and return false.
     *
     * @param messenger Most likely the same as passed to startup(...), but can be a different one.
     */
    boolean shutdown( SGMessenger messenger )
}
