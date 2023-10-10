/*
 *
 * PROJECT
 *     Name
 *         APS APIs
 *
 *     Code Version
 *         1.0.0
 *
 *     Description
 *         Provides the APIs for the application platform services.
 *
 * COPYRIGHTS
 *     Copyright (C) 2012 by Natusoft AB All rights reserved.
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
 * The base of all APSExceptions.
 *
 * This provides a non standard API in addtion to the standard API.
 *
 * From Groovy:
 *
 *   ` throw new SGException(message: "Something bad happened!", cause: badException) `
 *
 * From Java:
 *
 *   ` throw new SGException().appendMessage("Something bad happened!").addCause(badException); `
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
    SGException appendMessage(String text) {
        this.messageBuilder << " "
        this.messageBuilder << text

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