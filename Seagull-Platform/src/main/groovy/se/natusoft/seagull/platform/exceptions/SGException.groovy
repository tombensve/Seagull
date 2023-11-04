/*
 *
 * PROJECT
 *     Name
 *         Seagull-Platform
 *     
 *     Description
 *         Seagull - Currently a playground where I'm having fun.
 *         
 *         The idea here is to define a service platform that says
 *         nothing about how services communicate with each other.
 *         This defines APIs and not to many of those, that can be
 *         implemented with whatever protocol. The first implementation
 *         provided will be using REST. The actual services you write
 *         with this will however not know, nor care about that!
 *         
 *         THIS IS HOWEVER NOT a hide reality, making something look
 *         like something else it really isn't just to make it seem
 *         simpler! Any use of this requires a full comprehension of
 *         reality.
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
package se.natusoft.seagull.platform.exceptions

import groovy.transform.CompileStatic;

/**
 * The base of all Seagull exceptions. Actually Seagull only defines this!
 * If any service implementation wants to subclass this and use,go ahead,
 * but for the platform itself, this is it!
 *
 *   ` throw new SGException(message: "Something bad happened!", cause: somethingBadException) `
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
     * Creates a new _APSException_ instance.
     *
     * @param message The exception message.
     */
    SGException(String message) {
        this.messageBuilder << message
    }

    /**
     * Creates a new _APSException_ instance.
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
        return this.messageBuilder.toString()
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
        return hasCauses() ? this.causes.get(0) : null;
    }

    /**
     * Returns a list of causes for this exception.
     */
    List<Throwable> getCauses() {
        return this.causes;
    }

    /**
     * Returns true if there is at least one cause exception added to this exception.
     */
    boolean hasCauses() {
        return !this.causes.isEmpty();
    }

}
