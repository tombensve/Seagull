package se.natusoft.seagull.api

import groovy.transform.CompileStatic
import se.natusoft.lic.annotation.BinariesAvailableAt
import se.natusoft.lic.annotation.Human_Software_License_1_0
import se.natusoft.lic.annotation.SourceAvailableAt
import se.natusoft.seagull.SG_ID

@Human_Software_License_1_0
@SourceAvailableAt("https://github.com/tombensve/")
@BinariesAvailableAt("https://repo.repsy.io/mvn/tombensve/natusoft-os/")


/**
 * Represents a service provider.
 *
 * DO NOTE: There is nothing in this API that disallows for listening to multiple messages,
 * and serving several services in same instance! In general, it is a bad idea! But there are
 * possible situations when basically the same service can deal with slightly different
 * inputs. So I'm not making any restrictions!
 *
 * And YES, it is possible to register a ton of services in same class! I can however not
 * recommend that!!! The goal here is to keep things very simple from all perspectives!
 *
 * IMPORTANT!!! -> All services needs access to the one and only SGRouter implementation
 * that should be included in the jar file. This is is always available as:
 *
 *      SGRouter.Router
 *
 * If this fails then the jar file for this service is not correctly packaged!
 *
 * Googles AutoService jar should be in classpath to annotate implementations
 * with @AutoService . Otherwise you have to doing manually. Javas ServiceLoader is
 * used under the surface to get implementations.
 *
 * You need to register listeners in startup(), and unregister them in shutdown!
 * Sending messages can be done at any time using the Router.
 */

@CompileStatic

interface SGService {

    /**
     * @return The SG_ID of the service.
     */
    SG_ID serviceId()

    /**
     * Starts a service.
     *
     * Should start by doing:
     *
     *     UUID listenerUUID SGRouter.Router.registerListener( SGServiceId, { SGModel message ->...  } )
     *
     */
    void startup()


    /**
     *  Called on shutdown to unregister all registered listeners.
     *
     *      SGRouter.Router.unregisterListener( listenerUUID )
     */
    void shutdown()
}
