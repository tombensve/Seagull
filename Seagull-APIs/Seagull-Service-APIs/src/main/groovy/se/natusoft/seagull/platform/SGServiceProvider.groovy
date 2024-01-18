package se.natusoft.seagull.platform

import se.natusoft.seagull.platform.models.SGMessage

interface SGServiceProvider {

    /**
     * Implement this by using a Closure: { SGMessage serviceRequest -> ... }
     *
     * @param serviceRequest A closure as above.
     *
     * @return Response message.
     */
    SGMessage serviceHandler(SGMessage serviceRequest)
}
