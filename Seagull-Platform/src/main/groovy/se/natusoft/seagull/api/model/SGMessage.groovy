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
     * Sets the unique ID of the message.
     *
     * @param messageId The ID to set.
     */
    void setMessageId(UUID messageId)
    
    /**
     * @return unique ID for message.
     */
    UUID getMessageId()
    
    // ----------------------------------------------- //
    
    /**
     * @param source Who is sending message.
     */
    setSource( SGID source )
    
    /**
     * @return Who sent message.
     */
    SGID getSource()
    
    // ----------------------------------------------- //
    
    /**
     * Provide the target of the message. Do note that SGID defines a Broadcast constant
     * that can be used as a target: SGID.Broadcast
     *
     * @param target The SGID of the target to send message to.
     */
    void setTarget( SGID target )
    
    /**
     * @return The id of the target.
     */
    SGID getTarget()

    // ----------------------------------------------- //
    
    /**
     * Sets the operation to perform.
     *
     * @param operation The operation to perform.
     *
     * Note that this is a String and thus very loose!  Both sender and receiver
     * have to be in agreement what this means, how to interpret this! This
     * can be null!
     */
    @Optional( "Not all protocols are required to support this!" )
    @Optional( "This is here to make it easier to support REST!" )
    void setOperation( String operation )
    
    /**
     * Gets the operation to perform.
     *
     * @return The operation.
     */
    @Optional
    String getOperation()
}
