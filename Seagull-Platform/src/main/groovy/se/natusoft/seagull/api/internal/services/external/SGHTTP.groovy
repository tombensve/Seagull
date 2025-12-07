package se.natusoft.seagull.api.internal.services.external

import se.natusoft.lic.annotation.BinariesAvailableAt
import se.natusoft.lic.annotation.Human_Software_License_1_0
import se.natusoft.lic.annotation.SourceAvailableAt
import se.natusoft.seagull.api.model.SGMessage
import se.natusoft.seagull.tools.SGProviderLookup

@Human_Software_License_1_0
@SourceAvailableAt( "https://github.com/tombensve/Seagull" )
@BinariesAvailableAt( "https://repo.repsy.io/mvn/tombensve/natusoft-os/" )

/**
 * This API both provides HTTP requests and serves HTTP requests.
 *
 * Implementations should be in a own jar that can be dependent on. This
 * can use any HTTP solution out there to provide the functionality.
 *
 * But Seagull code should only use this API and not care nor be aware of
 * what provides implementation.
 *
 * This is what in Seagull language is called an external wrapper. Seagull
 * will only use this and not care what implements it.
 *
 * - Implementations must be fetchable via ServiceLoader!
 * - There can only be one implementation available runtime.
 */
interface SGHTTP extends SGExternalWrapper {
    
    /**
     * Provides an instance of the interface.
     */
    SGHTTP instance = SGProviderLookup.find( SGHTTP.class )

//.....................................................................................
    
    /**
     * This does an HTTP request to an URL with a message.
     * A reply message is returned.
     *
     * @param target The URL to call.
     * @param message The message to send .
     * @return Response message.
     */
    SGMessage sendRequest( URL target, SGMessage message )

//.....................................................................................
    
    /**
     * This handles a received HTTP request and provides a reply.
     *
     * @param request
     * @return response
     */
    SGMessage handleRequest( Closure<SGMessage> request )
    
}
