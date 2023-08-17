package se.natusoft.seagull.platform.models

import se.natusoft.seagull.platform.SGId
import se.natusoft.tools.modelish.Cloneable

// New IDEA UI uglifies comments on <Opt><cmd>L ... Otherwise I'm starting to approve of the new UI.

/**
 * <p>
 * This model identifies a unique service, and possibly a unique instance of it.
 * </p>
 * <p>
 * This should be used by a service to identify itself and to call other services.
 * Each service has a unique instance of this. The combination of identifier and
 * service name is unique for the service, but the identifier in itself unique for
 * the instance. There can be multiple instances of a service spread out on
 * different hosts / nodes.
 * </p>
 */
interface SGServiceId extends Cloneable<SGServiceId> {

    /**
     * This should be an UUID in string format since it will be passed in JSON.
     *
     * @param uuid The UUID string.
     *
     * @return self
     */
    SGServiceId setIdentifier(SGId id)

    SGId getIdentifier()

    /**
     * Sets the id of the node providing the service.
     *
     * @param uuid The id to set.
     *
     * @return self.
     */
    SGServiceId setNodeId(SGId id)

    SGId getNodeId()

    /**
     * This is the name of the service. All instances of the service have the same name,
     * but different and unique identifiers.
     *
     * @param name The name of the service.
     *
     * @return self.
     */
    SGServiceId setServiceName(String name)

    String getServiceName()
}
