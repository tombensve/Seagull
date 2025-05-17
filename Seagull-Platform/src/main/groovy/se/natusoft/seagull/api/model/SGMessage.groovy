package se.natusoft.seagull.api.model

import groovy.transform.CompileStatic
import se.natusoft.docutations.Nullable
import se.natusoft.lic.annotation.BinariesAvailableAt
import se.natusoft.lic.annotation.Human_Software_License_1_0
import se.natusoft.lic.annotation.SourceAvailableAt
import se.natusoft.tools.modelish.Factory

@Human_Software_License_1_0
@SourceAvailableAt("https://github.com/tombensve/")
@BinariesAvailableAt("https://repo.repsy.io/mvn/tombensve/natusoft-os/")

/**
 * This is a base model for all messages! This must be subclassed for specific messages!
 */
@CompileStatic
interface SGMessage<T> extends Factory<T> {

    /**
     * Sets CRUD operation. This fits protocols like REST, but can be useful
     * even with other protocols also.
     *
     * Note 1:  that this is a String! I'm not entirely sure Modelish supports
     * enums (yet). But the SG_CRUD enum can be used with .toString() in
     * the end to get a correct string value.
     *
     * @param crud Provides the CRUD operation requested.
     */
    @Nullable
    void setCrud( String crud )

    /**
     * @return The CRUD operation requested.
     */
    @Nullable
    String getCRUD()

    /**
     * Specify what model should be used to read the content of this message.
     *
     * Do note that this value is just an ID/Name identifying the model.
     * This base of a model should be subclassed, or in this case
     * sub-interfaced if that is a word! :-).
     *
     * In other words, the model type should tell which subclass of this to cast
     * this to. It is an indicator of what the full message is. Using a string
     * name like this was the only way I could come up with to be protocol
     * independent.
     *
     * @param modelType The model type specifier.
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
