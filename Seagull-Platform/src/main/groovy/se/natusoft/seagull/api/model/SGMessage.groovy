package se.natusoft.seagull.api.model

import groovy.transform.CompileStatic
import se.natusoft.lic.annotation.BinariesAvailableAt
import se.natusoft.lic.annotation.Human_Software_License_1_0
import se.natusoft.lic.annotation.SourceAvailableAt
import se.natusoft.tools.modelish.Factory

@Human_Software_License_1_0
@SourceAvailableAt("https://github.com/tombensve/")
@BinariesAvailableAt("https://repo.repsy.io/mvn/tombensve/natusoft-os/")

/**
 * This is a base model for all messages!
 *
 * Any message model should extend this one! Do note that this message is abstract!!
 */
@CompileStatic
interface SGMessage<T> extends Factory<T> {

    /**
     * Sets CRUD operation. This fits protocols like REST, but can be useful
     * even with other protocols also.
     *
     * Note that this is a String! I'm not entirely sure Modelish supports
     * enums (yet). But the SGCRUD enum can be used with .toString() in
     * the end to get a correct string value.
     *
     * @param crud Provides the CRUD operation requested. This is an enum!
     */
    void setCrud( String crud )

    /**
     * @return The CRUD operation requested.
     */
    String getCRUD()


    /**
     * Specify what model should be used to read the content of this message.
     *
     * Do note that this value is just an ID/Name identifying the model. It provides
     * no model structure! Such has to be documented for the service. However, since
     * I'm forcing a Modelish model, this base model is a Modelish model that
     * should be extended, services can provide Modelish submodels of this ready
     * to use.
     *
     * @param modelType Identify the message data model. This is a String that
     *                  This is a String version of an SGId instance!! Always
     *                  use SGId to create this!
     */
    void setModelType( String modelType )

    /**
     * Theoretically a service caller can provide different sub-models of this model
     * calling same service! This id can then be used to pick correct sub model of this
     * to read sent data.
     *
     * @return An SGId that represents the model type that will extend this message.
     */
    String getModelType()

    /*
     The above are common information required by all calls. Models of specific service
     calls should extend this and add the information it needs.
     */
}
