package se.natusoft.seagull.provider.rest

@se.natusoft.lic.annotation.Human_Software_License_1_0
@se.natusoft.lic.annotation.SourceAvailableAt( "https://github.com/tombensve/Seagull" )
@se.natusoft.lic.annotation.BinariesAvailableAt( "https://repo.repsy.io/mvn/tombensve/natusoft-os/" )

import groovy.transform.CompileStatic
import se.natusoft.seagull.SGID
import se.natusoft.seagull.api.SGLogger
import se.natusoft.seagull.api.SGProtocol
import se.natusoft.seagull.api.SGJsonMapConverter
import se.natusoft.seagull.api.model.SGMessage
import se.natusoft.seagull.exceptions.SGNotFoundException

/** hej
 * This provides an implementation of REST protocol.
 *
 * I have decided to use Undertow to handle the communication. Do note
 * that Undertow here is completely internal to this provider, thus not
 * available on any classpath outside of this provider.
 */
@CompileStatic
class SGRESTProtocolProvider implements SGProtocol {

//.....................................................................................
    
    /**
     * For this to work a valid implementation of SGJsonMapConverter must
     * be available on classpath.
     */
    private SGJsonMapConverter jsonMapConverter = SGJsonMapConverter.provider
    
//.....................................................................................
    
    SGRESTProtocolProvider() {
        SGLogger.instance.log( "Starting Seagull provided SGRESTProtocol." )
    }

//.....................................................................................
    
    String getType() { "REST" }

//.....................................................................................
    
    String getProviderName() { "SG-Default-REST" }

//.....................................................................................
    
    void send( SGMessage message ) throws SGNotFoundException {
        
    
    }

//.....................................................................................
    
    void registerReceiver( SGID receiverId, Closure<SGMessage> receiver ) {
    
    }

//.....................................................................................
    
    void unregisterReceiver( SGID receiverId ) {
    
    }

//.....................................................................................
    
    void shutdown() {
        
        SGLogger.instance.log( "Shutting down SGRestProtocol." )
    }
}
