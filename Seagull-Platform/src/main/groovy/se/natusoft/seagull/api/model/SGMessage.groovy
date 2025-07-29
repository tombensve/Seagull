package se.natusoft.seagull.api.model

import groovy.transform.CompileStatic
import se.natusoft.docutations.Note
import se.natusoft.docutations.Optional
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
 * This is a base model for all messages! This must be subclassed for specific messages!
 * This interface defines the common part of all Seagull messages!
 *
 * Actual messages should extend this!
 */
@CompileStatic
@ModelishModel
@Note( "This interface must be extended by actual messages!" )
abstract interface SGMessage<T> extends Factory<T> {
    
    /**
     * @param source Who is sending message.
     *
     * @return
     */
    setSource( SGID source )
    
    SGID getSource()
    
    /**
     * Provide the target of the message. Do note that SGID defines a Broadcast constant
     * that can be used as a target: SGID.Broadcast
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
     *        of protocol.
     */
    @Optional( "Not all protocols are required to support this!" )
    @Optional( "This is here to make it easier to support REST!" )
    void setOperation( SGOperation operation )
    
    /**
     * Gets the operation to perform.
     *
     * @return The operation.
     */
    @Optional
    SGOperation getOperation()
}
