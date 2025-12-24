package se.natusoft.seagull.provider.rest

@se.natusoft.lic.annotation.Human_Software_License_1_0
@se.natusoft.lic.annotation.SourceAvailableAt( "https://github.com/tombensve/Seagull" )
@se.natusoft.lic.annotation.BinariesAvailableAt( "https://repo.repsy.io/mvn/tombensve/natusoft-os/" )

import groovy.transform.CompileStatic
import io.undertow.server.RoutingHandler
import se.natusoft.seagull.SGID
import se.natusoft.seagull.api.SGLogger
import se.natusoft.seagull.api.SGProtocol
import se.natusoft.seagull.api.internal.services.external.SGJsonMapConverter
import se.natusoft.seagull.api.model.SGMessage
import se.natusoft.seagull.exceptions.SGNotFoundException
import se.natusoft.seagull.tools.SGProviderLookup

/**
 * This provides an implementation of REST protocol.
 *
 * I have decided to use Undertow to handle the communication. Do note
 * that Undertow here is completely internal to this provider, thus not
 * available on any classpath outside of this provider. It fulfils a very
 * specific functionality. Thereby it is not handled as a Seagull-
 * external-wrapper!
 */
@CompileStatic
class SGRESTProtocolProvider implements SGProtocol {
    
    private SGLogger logger = SGLogger.instance
    
    private router = new RoutingHandler( )

//.....................................................................................
    
    /**
     For this to work a valid implementation of SGJsonMapConverter must
     be available on classpath. Currently ServiceLoader is used to look
     this upp, but  that might change. Thereby the SGProviderLookup, which
     will not change outward, but possibly inward!
     
     This converts between JSON String and Map<String, Object>, on both
     directions. Whatever implements this is irrelevant, but there has
     to be an implementation available on classpath when running!
     SG-Gson-JSONMapConverter is a provider that implements this.
     Any implementation must be available on classpath runtime.
     ServiceLoader is used to find implementation. So any implementation
     needs to provie a META-INF/services text file containing the fully
     qualified name of provided implementation.
     
     I am not using Googles @AutoService due to repeated failures to make that work.
     Providing the META-INF file is rather easy.
     */
    private SGJsonMapConverter jsonMapConverter =
            SGProviderLookup.find( SGJsonMapConverter.class )

//.....................................................................................
    
    SGRESTProtocolProvider() {
        logger.log( "Starting Seagull provided SGRESTProtocol." )
    }

//.....................................................................................
    
    // Be very clear in protocol names names!
    
    @Override
    String getType() {
        "REST"
    }

//.....................................................................................
    
    @Override
    String getProviderName() {
        "SG-Default-REST"
    }

//.....................................................................................
    
    @Override
    void send( SGMessage message ) throws SGNotFoundException {
    
    }

//.....................................................................................
    
    @Override
    void registerReceiver( SGID receiverId, Closure<SGMessage> receiver ) {
    
    }

//.....................................................................................
    
    @Override
    void unregisterReceiver( SGID receiverId ) {
    
    }

//.....................................................................................
    
    @Override
    void shutdown() {
        
        logger.log( "Shutting down SGRestProtocol." )
    }
}
