package se.natusoft.seagull.provider.rest

import groovy.transform.CompileStatic
import io.undertow.Undertow
import io.undertow.server.HttpHandler
import io.undertow.server.HttpServerExchange
import io.undertow.util.Headers
import se.natusoft.lic.annotation.Apache_Software_License_2_0
import se.natusoft.seagull.SGLifecycle
import se.natusoft.seagull.api.SGLogger
import se.natusoft.seagull.api.SGProtocol
import se.natusoft.seagull.api.model.SGMessage
import se.natusoft.seagull.exceptions.SGNotFoundException

@CompileStatic
@Apache_Software_License_2_0
class SGRESTProtocol implements SGProtocol {

    private SGLogger logger = SGLogger.instance

    SGRESTProtocol() {
        logger.log( "Starting SGRESTProtocol!" )
    }

    /**
     * The name of the protocol, to be able to identify it!
     *
     * @return The name of the protocol.
     */
    @Override
    String protocolName() {
        return "REST"
    }

    /**
     * Specifies the provider of the protocol. The idea behind providing this
     * is to be able to filter on this or not this if there are more protocols
     * implementing REST as a protocol available.
     *
     * This might however go away again since to not complicate things more than
     * needed it might not be a good idea to use this.
     *
     * @return "Seagull"
     */
    String protocolProvider() {
        "Seagull"
    }

    /**
     * Sends a message to a service using a specific protocol..
     *
     * @param message The message to send.
     */
    @Override
    void send( SGMessage<?> message ) {

    }

    //
    // Listener Handling
    //

    private Map<UUID, Closure<SGMessage<?>>> listeners = [ : ] // One of many reasons why I love Groovy!

    /**
     * Registers a listener of received messages.
     *
     * @param from Listen to messages from this SGId.
     * @param listener The listener to be called when a message is received.
     *
     * @return An UUID representing this listener instance.
     */
    UUID registerListener( Closure<SGMessage<?>> listener ) {

        UUID listenerId = UUID.randomUUID()
        listeners.put( listenerId, listener )

        ensureServerIsRunning()

        listenerId
    }

    /**
     * Use the UUID gotten at registration to stop listening to more messages.
     *
     * @param listener The listener UUID to unregister.
     */
    @Override
    void unregisterListener( UUID listener ) {
        this.listeners.remove( listener )
    }

    /**
     * Indicates if the HTTP server should be running or not. This so that it will not
     * automatically be started again via a call to ensureServerIsRunning() if it has
     * been shut down. Otherwise any call to registerListener will bring it up again.
     *
     * A call to shutdown() will make this false.
     */
    private SGLifecycle httpServerState = SGLifecycle.NOT_STARTED

    /**
     * HTTP server instance.
     */
    private Undertow httpServer = null

    private ensureServerIsRunning() {
        if ( this.httpServer == null && this.httpServerState != SGLifecycle.SHUT_DOWN  &&
        this.httpServerState != SGLifecycle.STARTING) {
            this.httpServerState = SGLifecycle.STARTING
            startHTTPDServer()
            this.httpServerState = SGLifecycle.RUNNING
        }
    }

    /**
     * Starts the HTTP server used to handle HTTP requests. Currently Undertow is used.
     */
    private startHTTPDServer() {

        this.httpServerState = SGLifecycle.RUNNING

        int port = 8801

        InetAddress inetAddress = InetAddress.localHost

        //HttpServerExchange serverExchange

        boolean retry = true

        while ( retry ) {
            try {
                this.httpServer = Undertow.builder()
                        .addHttpListener( port, inetAddress.hostName )
                        .setHandler( new HttpHandler() {
                            //@Override
                            void handleRequest( final HttpServerExchange exchange ) throws Exception {
                                exchange.getResponseHeaders().put( Headers.CONTENT_TYPE, "application/json" )
                            }
                        } ).build()
                this.httpServer.start()

                retry = false
            }
            catch ( Exception e ) {
                println "Assuming port already used by other, trying another ..."
                ++port
                if ( port > 8999 ) {
                    retry = false
                    this.httpServerState = SGLifecycle.SHUT_DOWN
                    throw new SGNotFoundException( "ERROR: All ports (8801-8999) are already used!" )
                }
            }
        }

        System.out.println "SG:[ SGRestProtocol running on port: ${port} ]"

    }

    //
    // Shutdown cleanup
    //

    /**
     * Shuts down this Protocol.
     */
    void shutdown() {
        this.httpServerState = SGLifecycle.SHUT_DOWN
        this.listeners.clear()
        if ( this.httpServer != null ) this.httpServer.stop()
        this.httpServer = null
    }

}
