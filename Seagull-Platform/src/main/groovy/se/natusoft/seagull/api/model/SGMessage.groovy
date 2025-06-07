package se.natusoft.seagull.api.model

import groovy.transform.CompileStatic
import se.natusoft.lic.annotation.BinariesAvailableAt
import se.natusoft.lic.annotation.Human_Software_License_1_0
import se.natusoft.lic.annotation.SourceAvailableAt
import se.natusoft.seagull.SGID
import se.natusoft.tools.modelish.Factory
import se.natusoft.tools.modelish.ModelishModel

@Human_Software_License_1_0
@SourceAvailableAt( "https://github.com/tombensve/" )
@BinariesAvailableAt( "https://repo.repsy.io/mvn/tombensve/natusoft-os/" )

/**
 * This represents the senders information.
 */
@CompileStatic
@ModelishModel
interface SGMessageContent<T> extends Factory<T> {}

/**
 * This is a base model for all messages! This must be subclassed for specific messages!
 * This interface defines the common part of all Seagull messages!
 */
@CompileStatic // Not entirely sure this is needed for an interface, but does not hurt ...
@ModelishModel
interface SGMessage<T> extends Factory<T> {

    /**
     * Provide the target of the message. Do note that SGID defines a Broadcast constant
     * that can be used as a target!
     *
     * @param target The target to send message to.
     */
    void setTarget( SGID target )
    SGID getTarget()

    /**
     * Sets the operation to perform.
     *
     * @param operation Any SGOperation value with a toString() call.
     *        This because it is easier to handle this as a String
     *        rather than a JVM specific Enum! That said the SGOperation
     *        Enum defines the valid values. So pick such a valid enum
     *        value and then do toStrin() on it to ensure you are passing
     *        a valid value! My goal is to be able to provide any type
     *        of protocol, even binary such!
     */
    void setOperation( String operation )

    /**
     * Gets the operation to perform.
     *
     * @return The operation.
     */
    String getOperation()


    setMessageContent(SGMessageContent<?> messageContent)

    SGMessageContent<?> getMessageContent()

}
