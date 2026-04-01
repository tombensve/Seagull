package se.natusoft.seagull.api.model

import se.natusoft.lic.annotation.BinariesAvailableAt
import se.natusoft.lic.annotation.Human_Software_License_1_0
import se.natusoft.lic.annotation.SourceAvailableAt

@Human_Software_License_1_0
@SourceAvailableAt( "https://github.com/tombensve/Seagull" )
@BinariesAvailableAt( "https://repo.repsy.io/mvn/tombensve/natusoft-os/" )

/**
 * This represents a message id.
 *
 * This basically wraps an UUID. It contains a public boolean equals(...)
 * method. It does not provide anything by itself. It is a rather boring
 * thing. So why does it exists ? It is not because I like to type a lot ?
 * I DON'T!
 *
 * Do I like to type a lot of unnecessary stuff ? NOPE!
 *
 * How this is implemented can however be completely changed without
 * breaking other code. This could have been made into an interface and
 * an implementation, but that felt overkill in this case.
 *
 * The outward API should never ever change. The implementation however
 * can, and without breaking anything.
 *
 * Nowhere outward does it even hint about how it solves things internally!
 *
 * Do note that internally an UUID is used to provide the actual id!
 */
class SGMessageId {
    
    /**
     * Uses an UUID internally.
     */
    private UUID msgId

//.....................................................................................
    
    /**
     * Creates a new SGMessageId.
     */
    SGMessageId() {
        this.msgId = UUID.randomUUID( )
    }

//.....................................................................................
    
    /**
     * @return A String representation of this SGMessageId.
     */
    String toString() { this.msgId.toString( ) }

//.....................................................................................
    
    /**
     * Compares for equality.
     *
     * @param messageId The messageId to compare with.
     *
     * @return true or false.
     */
    boolean equals( SGMessageId messageId ) {
        messageId.msgId == this.msgId
    }
}
