package se.natusoft.seagull.platform.models

import groovy.transform.CompileStatic
import se.natusoft.tools.modelish.Cloneable

/**
 * Modelish model representing a specific service registration for registering
 * Seagull services.
 *
 * This is provided to each SGService implementation.
 *
 * Created like this: `SgServiceReg sgSvcReg = Modelish.create(ShServiceReg.class).serviceName("qaz")...`
 */
@CompileStatic
interface SGServiceReg extends Cloneable<SGServiceReg> {

    /** Sets name of the service */
    SGServiceReg setServiceName(String name)

    /** Gets the name of the service. */
    String getServiceName()

    /** sets the version of the service. */
    SGServiceReg setServiceVersion(float serviceVersion)

    /** Gets the name of the service. */
    float getServiceVersion()

    /** Sets the backwards compatible flag of the service. */
    SGServiceReg setBackwardsCompatible(boolean backwardsCompatible)

    /** Returns the backwards compatible flag of the service. */
    boolean getBackwardsCompatible()
}