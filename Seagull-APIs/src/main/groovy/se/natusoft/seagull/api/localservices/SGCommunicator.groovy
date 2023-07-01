package se.natusoft.seagull.api.localservices

import groovy.transform.CompileStatic
import se.natusoft.seagull.api.SGHandler
import se.natusoft.seagull.api.models.SGMessage
import se.natusoft.seagull.api.models.SGResult
import se.natusoft.seagull.base.SGLocalService
import se.natusoft.docutations.NotNull
import se.natusoft.docutations.Nullable
import se.natusoft.docutations.Optional

/**
 * This is a local service that should be service loaded by any service that
 * wants to communicate with the outside world ...
 */
@CompileStatic
interface SGCommunicator extends SGLocalService {

    /**
     * Register a receiver of messages.
     *
     * @param serviceName The name of the specific service, for others to be able to call it.
     * @param messageHandler Receives an APSJSon message.
     */
    void registerMessageReceiver( String serviceName, @NotNull Closure<SGMessage> messageHandler )

    /**
     * Sends a message. Any potential target of the message is specified in the
     * message.
     *
     * @param message The message to send.
     * @param resultHandler The handler to call with status of the call.
     */
    void send( @NotNull SGMessage message,
               @Optional @Nullable SGHandler<SGResult<?>> resultHandler )

}
