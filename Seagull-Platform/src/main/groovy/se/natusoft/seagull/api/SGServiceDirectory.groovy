package se.natusoft.seagull.api

import se.natusoft.seagull.SGID
import se.natusoft.lic.annotation.*

@Human_Software_License_1_0
@SourceAvailableAt( "https://github.com/tombensve/" )
@BinariesAvailableAt( "https://repo.repsy.io/mvn/tombensve/natusoft-os/" )
interface SGServiceDirectory {
    
    /**
     * Registers a service.
     *
     * @param serviceId The unique ID of the service.
     * @param local true if this service is available locally, false otherwise.
     *
     * @return self for chaining calls.
     */
    SGServiceDirectory registerService( SGID serviceId, UUID node )
    
    /**
     * Unregisters a service.
     *
     * @param serviceId A unique id of the service to unregister.
     *
     * @return self for chaining calls.
     */
    SGServiceDirectory unregisterService( SGID serviceId, UUID node )
    
    
    /**
     * Returns true if service is available, locally or elsewhere.
     *
     * @param serviceId The service ID to look up.
     *
     * @return true or false.
     */
    boolean isServiceAvailable( SGID serviceId )
    
    
    /**
     * This validates that the service with the specified ID is available
     * locally in same jar.
     *
     * @param serviceId
     * @return true or false
     */
    boolean isServiceAvailableLocally( SGID serviceId )
}
