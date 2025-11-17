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
    
    /**
     * Uses an UUID internally.
     */
    private UUID msgId
    
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ //

    /**
     * Creates a new SGMessageId.
     */
    SGMessageId() {
        this.msgId = UUID.randomUUID(  )
    }
    
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ //
    
    /**
     * @return A String representation of this SGMessageId.
     */
    String toString() { this.msgId.toString(  ) }
    
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ //
    
    /**
     * Compares for equality.
     *
     * @param messageId The messageId to compare with.
     *
     * @return true or false.
     */
    boolean equals(SGMessageId messageId) {
        messageId.msgId == this.msgId
    }
}
