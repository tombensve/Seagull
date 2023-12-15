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
 *         2023-11-04: Created!
 *         
 */
package se.natusoft.seagull.platform.models

import groovy.transform.CompileStatic
import se.natusoft.docutations.Note
import se.natusoft.tools.modelish.Cloneable

/**
 * Modelish model representing a specific service registration for registering
 * Seagull services.
 *
 * This is provided to each SGService implementation.
 */
@CompileStatic
@Note("Modelish model!")
interface SGMessageId extends Cloneable<SGMessageId> {

    // Name
    /** Sets name of the service */
    SGMessageId messageType(String messageType)

    /** Gets the name of the service. */
    String getMessageType()

    // ServiceVersion
    /** sets the version of the service. */
    SGMessageId messageVersion(int messageVersion)

    /** Gets the name of the service. */
    int getMessageVersion()



    // backwardsCompatible
    /** Sets the backwards compatible flag of the service. */
    SGMessageId backwardsCompatible(boolean backwardsCompatible)

    /** Returns the backwards compatible flag of the service. */
    boolean isBackwardsCompatible()
}
