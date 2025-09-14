package se.natusoft.seagull.api.model

import groovy.transform.CompileStatic
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
 * I have been thinking back and forth here! My first thinking was to
 * make a message with common protocol stuff, and have one field with
 * the message payload as part of that. But since this code here
 * will not know what type that is, how do I type it ? Then it hit
 * me that by just extending this Modelish model and provide the
 * call data there in the extension it will be rather clear code-
 * wise without needing to handle an unknown model here!
 *
 * Also note that I make this base part of model a Modelish "factory".
 * This means that the whole object can be locked for change, and
 * then be cloned if modification of content is wanted in a safe way.
 * Modelish do support immutable models very easily, and can
 * clone the content of a model, also easily.
 *
 * This model must be extended by actual messages! This information
 * is only about who is sending and who is receiving.*/
@CompileStatic
@ModelishModel( desc = "Defines a base message." )
interface SGMessage<T> extends Factory<T> {
    
    /**
     * Sets the message direction, of this. Can be "MES" or "RES"
     *
     * @param messageDirection The direction to set. Use MessageDirection enum for values.
     *                          Do .toString() on the enum values.
     */
    void setMessageDirection(String messageDirection)
    
    String getMessageDirection()
    
    /**
     * Sets the unique ID of the message.
     *
     * @param messageId The ID to set.
     */
    void setMessageId( UUID messageId )
    
    /**
     * @return unique ID for message.
     */
    UUID getMessageId()

/**
 * @param source Who is sending message.
 */
    setSource( SGID source )

/**
 * @return Who sent message.
 */
    SGID getSource()

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
    
    /**
     * Provides meta data.
     *
     * @param metaData Optional meta data to proved. Can be used to support
     *                 REST action for example.
     */
    @Optional
    void setMetaData( String metaData )
    
    String getMetaData()
}
