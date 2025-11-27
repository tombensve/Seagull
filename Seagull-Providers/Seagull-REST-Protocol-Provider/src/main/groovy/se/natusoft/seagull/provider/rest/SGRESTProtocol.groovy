package se.natusoft.seagull.provider.rest

import groovy.transform.CompileStatic
import se.natusoft.lic.annotation.BinariesAvailableAt
import se.natusoft.lic.annotation.Human_Software_License_1_0
import se.natusoft.lic.annotation.SourceAvailableAt
import se.natusoft.seagull.SGID
import se.natusoft.seagull.SGLifecycle
import se.natusoft.seagull.api.SGLogger
import se.natusoft.seagull.api.SGProtocol
import se.natusoft.seagull.api.model.SGMessage
import se.natusoft.seagull.exceptions.SGNotFoundException

@Human_Software_License_1_0
@SourceAvailableAt( "https://github.com/tombensve/Seagull" )
@BinariesAvailableAt( "https://repo.repsy.io/mvn/tombensve/natusoft-os/" )

@CompileStatic
class SGRESTProtocol implements SGProtocol {
    
    private SGLogger logger = SGLogger.instance
    
    private SGLifecycle httpServerState = SGLifecycle.NOT_STARTED
    
    
    SGRESTProtocol() {
        logger.log( "Starting SGRESTProtocol!" )
    }
    
    @Override
    String getType() {
        return null
    }
    
    @Override
    String getProviderName() {
        return null
    }
    
    @Override
    void send( SGMessage message ) throws SGNotFoundException {
    
    }
    
    @Override
    void registerReceiver( SGID receiverId, Closure<SGMessage> receiver ) {
    
    }
    
    @Override
    void unregisterReceiver( SGID receiverId ) {
    
    }
    
    @Override
    void shutdown() {
    
    }
}
