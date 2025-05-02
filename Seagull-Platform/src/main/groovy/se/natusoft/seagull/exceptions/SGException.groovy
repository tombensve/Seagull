package se.natusoft.seagull.exceptions

import groovy.transform.CompileStatic
import se.natusoft.lic.annotation.BinariesAvailableAt
import se.natusoft.lic.annotation.Human_Software_License_1_0
import se.natusoft.lic.annotation.SourceAvailableAt

@Human_Software_License_1_0
@SourceAvailableAt("https://github.com/tombensve/")
@BinariesAvailableAt("https://repo.repsy.io/mvn/tombensve/natusoft-os/")

/**
 * The base of all Seagull exceptions. Actually Seagull only defines this!
 *
 *     throw new SGException( message: "Something bad happened!", cause: somethingBadException )
 */
@CompileStatic
class SGException extends RuntimeException {

    //
    // Private Members
    //

    /** The exception message. */
    private StringBuilder messageBuilder = new StringBuilder()

    /** Support for multiple causes for this exception. */
    private List<Throwable> causes = new LinkedList<>()

    //
    // Constructors
    //

    /**
     * Creates a new SGException.
     */
    SGException() {}


    /**
     * Creates a new SGException.
     *
     * @param message The exception message.
     */
    SGException(String message) {
        this.messageBuilder << message
    }


    /**
     * Creates a new SGException.
     *
     * @param message The exception message.
     * @param cause The cause of this exception.
     */
    SGException(String message, Throwable cause) {
        this.messageBuilder << message
        this.causes << cause
    }


    //
    // Methods
    //

    /**
     * Adds text the the exception message.
     *
     * @param text The text to add.
     */
    SGException append(String text) {
        this.messageBuilder << " "
        this.messageBuilder << text

        this
    }


    /**
     * Allows to use the left-shift operator (<<) to add text.
     *
     * @param text
     * @return self.
     */
    SGException leftShift(String text) {
        append(text)
        this
    }


    /**
     * Returns the exception message.
     */
    @Override
    String getMessage() {
        this.messageBuilder.toString()
    }


    /**
     * Adds a cause to this exception.
     *
     * @param cause The cause to add.
     */
    SGException appendCause(Throwable cause) {

        this.causes << cause
        this
    }


    /**
     * Allows to use the left-shift operator to add an exception.
     *
     * @param cause The exception to add.
     * @return self.
     */
    SGException leftShift(Throwable cause) {
        appendCause(cause)
        this
    }


    /**
     * Override to return the first cause in the list if any. If no causes then null is returned.
     */
    @Override
    synchronized Throwable getCause() {
        hasCauses() ? this.causes.last() : new RuntimeException(("[Unknown cause!]"))
    }


    /**
     * Returns a list of causes for this exception.
     */
    List<Throwable> getCauses() {
        this.causes
    }


    /**
     * Returns true if there is at least one cause exception added to this exception.
     */
    boolean hasCauses() {
        !this.causes.isEmpty()
    }


    /**
     * This is an alternative to getMessage().
     *
     * @return The exception message!
     */
    @Override
    String toString() {
        this.messageBuilder.toString()
    }
}
