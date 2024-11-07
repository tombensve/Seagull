/*
 *
 * PROJECT
 *     Name
 *         Seagull-Service-APIs
 *     
 *     Description
 *         Seagull - Intended to be a very simplistic service platform.
 *         
 *         The idea here is to define a service platform that says
 *         nothing about how services communicate with each other.
 *         This defines APIs and not to many of those, that can be
 *         implemented with whatever protocol. What protocol is used
 *         depends on what implementation you make available on
 *         the classpath. Implementations are fetched using
 *         SGProviderLookup (currently ServiceLoader is used).
 *         
 * COPYRIGHTS
 *     Copyright (C) 2023 by Tommy Bengt Svensson All rights reserved.
 *     
 * LICENSE
 *     Apache 2.0 (Open Source)
 *     
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *     
 *       http://www.apache.org/licenses/LICENSE-2.0
 *     
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 *     
 * AUTHORS
 *     tommy ()
 *         Changes:
 *         2011-07-22: Created!
 *
 */
package se.natusoft.seagull.exceptions

import groovy.transform.CompileStatic

/**
 * The base of all Seagull exceptions. Actually Seagull only defines this!
 * If any service implementation wants to subclass this and use, go ahead,
 * but for the platform itself, this is it!
 *
 *     throw new SGException(message: "Something bad happened!", cause: somethingBadException)
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

    /* _______________________________________________________________________________ */

    /**
     * Creates a new SGException.
     *
     * @param message The exception message.
     */
    SGException(String message) {
        this.messageBuilder << message
    }

    /* _______________________________________________________________________________ */

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

    /* _______________________________________________________________________________ */

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

    /* _______________________________________________________________________________ */

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

    /* _______________________________________________________________________________ */

    /**
     * Returns the exception message.
     */
    @Override
    String getMessage() {
        this.messageBuilder.toString()
    }

    /* _______________________________________________________________________________ */

    /**
     * Adds a cause to this exception.
     *
     * @param cause The cause to add.
     */
    SGException appendCause(Throwable cause) {

        this.causes << cause
        this
    }

    /* _______________________________________________________________________________ */

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

    /* _______________________________________________________________________________ */

    /**
     * Override to return the first cause in the list if any. If no causes then null is returned.
     */
    @Override
    synchronized Throwable getCause() {
        hasCauses() ? this.causes.last() : new RuntimeException(("[Unknown cause!]"))
    }

    /* _______________________________________________________________________________ */

    /**
     * Returns a list of causes for this exception.
     */
    List<Throwable> getCauses() {
        this.causes
    }

    /* _______________________________________________________________________________ */

    /**
     * Returns true if there is at least one cause exception added to this exception.
     */
    boolean hasCauses() {
        !this.causes.isEmpty()
    }

    /* _______________________________________________________________________________ */

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
