package se.natusoft.seagull.platform

import se.natusoft.docutations.DOC_Note

/**
 * This is implemented by each service.
 */
interface SGService {

    /**
     * This gets called on startup.
     *
     * @param router The router to use for sending messages.
     */
    @DOC_Note( [
            "It is physically possible to use this and register multiple services in one",
            "startup(...) call! PLEASE DON'T! Each SGService represents one service! There",
            "will be no way of of keeping track of services if you register more than one!",
            "And each implementation of SGService will get its own startup(router) call!"
    ] )
    void startup( SGRouter router )

    /**
     * This is called on shutdown for eventual cleanup.
     */
    void shutdown( SGRouter router )
}
