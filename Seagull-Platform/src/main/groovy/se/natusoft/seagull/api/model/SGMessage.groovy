package se.natusoft.seagull.api.model

import groovy.transform.CompileStatic
import se.natusoft.lic.annotation.BinariesAvailableAt
import se.natusoft.lic.annotation.Human_Software_License_1_0
import se.natusoft.lic.annotation.SourceAvailableAt
import se.natusoft.seagull.SGID
import se.natusoft.tools.modelish.Factory
import se.natusoft.tools.modelish.ModelishModel

@Human_Software_License_1_0
@SourceAvailableAt("https://github.com/tombensve/Seagull")
@BinariesAvailableAt( "https://repo.repsy.io/mvn/tombensve/natusoft-os/" )

/**
 * This is a base model for all messages! This must be subclassed
 * for specific messages! This interface defines the common part of
 * all Seagull messages!
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
 *
 * This model must be extended by actual messages! This information
 * is only about who is sending and who is receiving.
 *
 * This model is a "Modelish" model. Modelish is another project from
 * me. Modelish only uses interfaces and provides dynamic implementations
 * when created. In addition to JavaBean standard it also supports
 * another model standard whose name I cannot remember, but that
 * skips the get and set and let first character always be lowercase.
 * This shortens the method name by 3 characters. The reason I don't
 * use this feature here is that this is Groovy code and Groovy lets
 * me skip get get & set parts when using property access, even if
 * the "set" and "get" is there. But in Java it makes sense to use
 * the shorter variants.
 *
 * Anyhow, Modelish will provide an implementation for setting and
 * getting values. Internally it stores values in HashMap's.
 *
 * This makes it easy to convert to and from JSON. Modelish models
 * can also be be made immutable by locking them. A locked model
 * cannot be unlocked, only cloned!
 *
 * NOTE that this interface is abstract!! It MUST be extended with
 * a specific message!
 */
@CompileStatic
@ModelishModel( desc = "Defines a base message." )
interface SGMessage<T> extends Factory<T> {
    
    /**
     * Provides a unique ID for the message!
     */
    void setMessageId( SGMessageId messageId )
    SGMessageId getMessageId()
    
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ //
    
    /**
     * The ID of the received message being responded to.
     * This should of course be
     *
     * @param messageId
     */
    void setInResponseTo( SGMessageId messageId )
    SGMessageId getInResponseTo()
    
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ //
    
    /**
     * Provides the sender of the message.
     */
    setSource( SGID source )
    SGID getSource()
    
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ //
    
    /**
     * Provides the target of the message. Do note that SGID defines a Broadcast constant
     * that can be used as a target: SGID.Broadcast
     *
     * @param target The SGID of the target to send message to.
     */
    void setTarget( SGID target )
    SGID getTarget()
    
    // Specific messages MUST extend this!
}
