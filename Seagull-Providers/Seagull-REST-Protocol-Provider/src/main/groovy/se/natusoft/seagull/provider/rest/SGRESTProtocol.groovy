package se.natusoft.seagull.provider.rest

import groovy.transform.CompileStatic
import io.undertow.Undertow
import io.undertow.server.RoutingHandler
import io.undertow.server.protocol.http2.Http2ServerConnection
import se.natusoft.lic.annotation.BinariesAvailableAt
import se.natusoft.lic.annotation.Human_Software_License_1_0
import se.natusoft.lic.annotation.SourceAvailableAt
import se.natusoft.seagull.SGID
import se.natusoft.seagull.SGLifecycle
import se.natusoft.seagull.api.SGLogger
import se.natusoft.seagull.api.SGProtocol
import se.natusoft.seagull.api.model.SGMessage
import se.natusoft.seagull.exceptions.SGNotFoundException
import se.natusoft.tools.modelish.Model

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
@Human_Software_License_1_0
@SourceAvailableAt( "https://github.com/tombensve/Seagull" )
@BinariesAvailableAt( "https://repo.repsy.io/mvn/tombensve/natusoft-os/" )

@CompileStatic
class SGRESTProtocol implements SGProtocol {
    
    // Convenience / cosmetics to log using logger.log(...) rather than SGLogger.instance.log(...).
    private SGLogger logger = SGLogger.instance
    
    private SGLifecycle httpServerState = SGLifecycle.NOT_STARTED
    
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
    
    SGRESTProtocol() {
        logger.log( "Starting SGRESTProtocol!" )
    }
    
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
    
    def underTowRouter = new RoutingHandler( )
    
    String getType() { "REST" }
    
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
    
    String getProvider() { "Seagull" }
    
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
    
    /**
     * Sends a message to a service using a specific protocol..
     *
     * @target The target to send to.
     * @param message The message to send.
     */
    void send( SGID target, SGMessage<?> message ) throws SGNotFoundException {
    
    }
    
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
    
    /**
     * Holds the registered receivers.
     */
    private Map<SGID, Closure<SGMessage>> receivers = [ : ]
    
    // If this is marked as non existing at the top, but required due to being in
    // interface being implemented, THEN YOU ARE USING IDEA!!!
    // Code compiles perfectly due to knowing what IDEA fails to figure out.
    
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
    
    /**
     * HTTP server instance.
     */
    private Http2ServerConnection httpServer = null
    
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
    
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
            
            startHTTPDServer( )
            
            if ( this.httpServerState == SGLifecycle.SHUT_DOWN ) {
                
                logger.log( "ERROR: Failed to start server, probably due to no ports being available!" )
            } else {
                this.httpServerState = SGLifecycle.RUNNING
            }
        }
    }
    
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
    
    /**
     * Starts the HTTP server used to handle HTTP requests. Currently Undertow is used.
     */
    private void startHTTPDServer() {
        
        
        this.httpServerState = SGLifecycle.RUNNING
        
        // Hope this is odd enough to in general not be used :-). But if this is busy
        // we will try all the way up tp 9999 before giving up! What port end up being used
        // will be logged!
        
        // This will start at 9900 and try up to 9999 for a free port. The actual port will
        // be registered in the service directory. Goal: each sender should provide its own
        // port. That requires an extension to SGMessage!
        int port = 9900
        
        InetAddress inetAddress = InetAddress.localHost
        
        boolean retry = true
        final Undertow undertow
        while ( retry ) {
            
            try {
                //final def undertow
                
                // ...
                
                retry = false
                
                logger.log( "SGRestProtocol running on port: ${ port }" )
            }
            catch ( Exception e ) {
                
                // TODO: Replace this with getting port number from config!
                
                logger.log( "Port ${ port } already used, trying another ..." )
                ++port
                if ( port > 9598 ) { // Reserving 9599 for a registry!
                    retry = false
                    
                    // TO DO: Make port configurable!
                    logger.log( "ERROR: Failed to start service due to lack of available ports!" )
                    this.httpServerState = SGLifecycle.SHUT_DOWN
                }
            }
        } // retry
    }
    
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
    
    /**
     *
     *
     * @param requestStream
     * @return
     */
    private Model readRequest( InputStream requestStream ) {
    
    }
    
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
    
    private writeResponse( OutputStream responseStream, Model response ) {
    
    }
    
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
    
    private Map<UUID, Closure<SGMessage>> listeners = [ : ] // Groovy's way of saying Map!
    
    /**
     * Registers a listener of received messages.
     *
     * @param from Listen to messages from this SGId.
     * @param listener The listener to be called when a message is received.
     *
     * @return An UUID representing this listener instance.
     */
    UUID registerListener( Closure<SGMessage<?>> listener ) {
        
        UUID listenerId = UUID.randomUUID( )
        this.listeners[ listenerId ] << listener
        
        ensureServerIsRunning( )
        
        listenerId
    }
    
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
    
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
    
    void registerReceiver( SGID receiverId, Closure<SGMessage> receiver ) {
    
    }
    
    @Override
    void unregisterReceiver( SGID receiverId ) {
    
    }
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
    
    /**
     * Shuts down this Protocol.
     */
    @Override
    void shutdown() {
        
        this.httpServerState = SGLifecycle.SHUT_DOWN
        this.listeners.clear( )
        if ( this.httpServer != null ) this.httpServer.close( )
        this.httpServer = null
    }
    
}
