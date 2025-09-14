package se.natusoft.seagull.api

import se.natusoft.seagull.SGID
import se.natusoft.lic.annotation.*
import se.natusoft.seagull.tools.SGProviderLookup

@Human_Software_License_1_0
@SourceAvailableAt("https://github.com/tombensve/Seagull")
@BinariesAvailableAt( "https://repo.repsy.io/mvn/tombensve/natusoft-os/" )
interface SGServiceDirectory {
    
    /**
     * Service directory instance.
     *
     * Do note that if no implementation of SGServiceDirectory is made
     * available in jar file, then this will result in null
     */
    public static final SGServiceDirectory instance
            = SGProviderLookup.find( SGServiceDirectory.class )
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
