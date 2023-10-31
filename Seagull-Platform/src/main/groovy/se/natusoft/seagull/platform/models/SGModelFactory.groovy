package se.natusoft.seagull.platform.models

import groovy.transform.CompileStatic
import se.natusoft.tools.modelish.Modelish

/**
 * Utility for creating argument models. Let any class using this implement this trait.
 */
@CompileStatic
trait SGModelFactory {

    /**
     * Creates the model needed for registering a new Seagull service.
     */
    static SGServiceReg newSGServiceReg() {
        Modelish.create(SGServiceReg.class)
    }

    /**
     * Creates a model instance for making a service call.
     */
    static SGServiceCall newSGServiceCall() {
        Modelish.create(SGServiceCall.class)
    }
}
