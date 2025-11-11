package se.natusoft.seagull.api.model

import se.natusoft.lic.annotation.BinariesAvailableAt
import se.natusoft.lic.annotation.Human_Software_License_1_0
import se.natusoft.lic.annotation.SourceAvailableAt

@Human_Software_License_1_0
@SourceAvailableAt("https://github.com/tombensve/Seagull")
@BinariesAvailableAt( "https://repo.repsy.io/mvn/tombensve/natusoft-os/" )

/**
 * This represents a message id.
 */
class SGMessageId {
    
    private String msgId
    
    /**
     * Creates a new SGMessageId.
     */
    SGMessageId() {
        this.msgId = UUID.randomUUID(  ).toString(  )
    }
    
    /**
     * @return A String representation of this SGMessageId.
     */
    String toString() { getId() }
    
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ //
    
    /**
     * @return Returns same String as toString().
     */
    String getId() { this.msgId }
    
    /**
     * Compares for equality.
     *
     * @param messageId The messageId to compare with.
     *
     * @return true or false.
     */
    boolean equals(SGMessageId messageId) {
        messageId == this.msgId.toString(  )
    }
}
