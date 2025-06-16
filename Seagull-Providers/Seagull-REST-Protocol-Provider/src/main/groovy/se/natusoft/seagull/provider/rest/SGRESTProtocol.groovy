package se.natusoft.seagull.provider.rest

import com.google.auto.service.AutoService
import groovy.transform.CompileStatic
import io.undertow.Undertow
import io.undertow.server.HttpHandler
import io.undertow.server.HttpServerExchange
import io.undertow.util.Headers
import se.natusoft.docutations.Todo
import se.natusoft.lic.annotation.BinariesAvailableAt
import se.natusoft.lic.annotation.Human_Software_License_1_0
import se.natusoft.lic.annotation.SourceAvailableAt
import se.natusoft.seagull.SGLifecycle
import se.natusoft.seagull.SGID
import se.natusoft.seagull.api.SGLogger
import se.natusoft.seagull.api.SGProtocol
import se.natusoft.seagull.api.model.SGMessage
import se.natusoft.tools.modelish.Model

@Human_Software_License_1_0
@SourceAvailableAt("https://github.com/tombensve/")
@BinariesAvailableAt("https://repo.repsy.io/mvn/tombensve/natusoft-os/")

@CompileStatic
@AutoService(SGProtocol.class)
class SGRESTProtocol implements SGProtocol {

    // Convenience / cosmetics to log using logger.log(...) rather than SGLogger.instance.log(...).
    private SGLogger logger = SGLogger.instance

    SGRESTProtocol() {
        logger.log( "Starting SGRESTProtocol!" )
    }

    /**
     * Name of protocol.
     */
    String name() { "SGRestProtocol" }

    /**
     * Sends a message to a service using a specific protocol..
     *
     * @param The message to send.
     */
    @Override
    void send( SGID target, SGMessage<?> data ) {

    }

    /**
     * Registers a listener of received messages.
     *
     * @param listener The listener to be called when a message is received.
     *
     * @return An UUID representing this listener instance.
     */
    @Override
    void registerListener( SGID service, Closure<SGMessage<?>> listener ) {

    }

    /**
     * Use the UUID gotten at registration to stop listening to more messages.
     *
     * @param listener The listener UUID to unregister.
     */
    @Override
    void unregisterListener( SGID listener ) {

    }

    /**
     * The name of the protocol, to be able to identify it!
     */
    String protocolType() { "REST" }

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
    static String protocolProvider() { "Seagull default REST provider" }

    // ---------------------------------------------------------------------------//

    private Map<UUID, Closure<SGMessage<?>>> listeners = [ : ]

    // If the editor places this comment in the same "box" as the above method and
    // comment then you are using IDEA!! This is a comment for the below method,
    // and nothing else! Until JettBrains get their shit working again (if ever)
    // I suggest not using that feature since it confuses things. I'm assuming
    // that they have lost a lot of competent people since they are not living
    // up to their name any more. That said it still beats most other alternatives ...

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

    /**
     * This is responsible for trying to bring upp server. As anything it can of course fail!
     *
     * Note also that we check that the service is not already in the process of starting!
     * Shit can always happen!
     */
    private void ensureServerIsRunning() {

        if ( this.httpServer == null && this.httpServerState != SGLifecycle.SHUT_DOWN &&
                this.httpServerState != SGLifecycle.STARTING ) {

            this.httpServerState = SGLifecycle.STARTING

            startHTTPDServer()

            if ( this.httpServerState == SGLifecycle.SHUT_DOWN ) {

                logger.log( "ERROR: Failed to start server, probably due to no ports being available!" )
            } else {
                this.httpServerState = SGLifecycle.RUNNING
            }
        }
    }

    /**
     * Starts the HTTP server used to handle HTTP requests. Currently Undertow is used.
     */
    private void startHTTPDServer() {


        this.httpServerState = SGLifecycle.RUNNING

        // Hope this is odd enough to in general not be used :-). But if this is busy
        // we will try all the way up tp 9999 before giving up! What port end up being used
        // will be logged!
        @Todo(description = "Chose a set of 10 ports spread out")
        int port = 9900

        InetAddress inetAddress = InetAddress.localHost

        boolean retry = true

        while ( retry ) {
            try {
                final def undertow = this.httpServer = Undertow.builder()
                        .addHttpListener( port, inetAddress.hostName )
                        .setHandler( new HttpHandler() {

                            @Override
                            void handleRequest( final HttpServerExchange exchange ) throws Exception {
                                exchange.getResponseHeaders().put( Headers.CONTENT_TYPE,
                                        "application/json" )

                                exchange.inputStream

                                exchange.outputStream
                            }

                        } ).build()
                //undertow

                this.httpServer.start()

                retry = false

                logger.log( "SGRestProtocol running on port: ${port}" )
            }
            catch ( Exception e ) {

                // TODO: Replace this with getting port number from config!

                logger.log( "Port ${port} already used, trying another ..." )
                ++port
                if ( port > 9998 ) { // Reserving 9999 for a registry!
                    retry = false

                    // TO DO: Make port configurable!
                    logger.log( "ERROR: Failed to start service due to lack of available ports!" )
                    this.httpServerState = SGLifecycle.SHUT_DOWN
                }
            }
        } // retry
    }

    // ------------------------------------------------------------------------------------------//

    /**
     *
     *
     * @param requestStream
     * @return
     */
    private Model readRequest( InputStream requestStream) {

    }

    private writeResponse(OutputStream responseStream, Model response) {

    }

    // ------------------------------------------------------------------------------------------//

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
        this.listeners.put( listenerId, listener )

        ensureServerIsRunning()

        listenerId
    }

    /**
     * Use the UUID gotten at registration to stop listening to more messages.
     *
     * @param listener The listener UUID to unregister.
     */
    void unregisterListener( UUID listener ) {
        this.listeners.remove( listener )
    }

    /**
     * Sends a message to a service using a specific protocol..
     *
     * @param message The message to send.
     */
    void send( SGMessage<?> message ) {

    }

    // ------------------------------------------------------------------------------------------//

    /**
     * Shuts down this Protocol.
     */
    @Override
    void shutdown() {
        this.httpServerState = SGLifecycle.SHUT_DOWN
        this.listeners.clear()
        if ( this.httpServer != null ) this.httpServer.stop()
        this.httpServer = null
    }

}
