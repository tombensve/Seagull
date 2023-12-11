/* 
 * 
 * PROJECT
 *     Name
 *         Seagull-Service-APIs
 *     
 *     Description
 *         Seagull - Intended to be a very simple service platform.
 *         
 *         The idea here is to define a service platform that says
 *         nothing about how services communicate with each other.
 *         This defines APIs and not to many of those, that can be
 *         implemented with whatever protocol. What protocol is used
 *         depends on what implementation you make available on
 *         the classpath.
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
import se.natusoft.seagull.platform.SGAction
import se.natusoft.seagull.platform.SGJson
import se.natusoft.tools.modelish.Cloneable

/**
 * Modelish model representing data needed to call a service.
 */
@Note([
        "JavaBean variant of 'property' values are used due to Groovys property access of those.",
        "I.e it allows for sgCall.to='...'. That said the model is a builder, so when creating ",
        "you probably want to use the builder, but to access values property variant can be used."
])
@CompileStatic
interface SGRequest extends Cloneable<SGRequest> {

    /**
     * @param messageId Provides message type and version of the request.
     *
     * @return self.
     */
    SGRequest messageId(SGMessageId messageId)

    /**
     * @return The name of the service to call.
     */
    SGMessageId getMessageId()

    /**
     * @param crud The CRUD operation to perform.
     * @return self.
     */
    SGRequest action(SGAction action)

    /**
     * @return The CRUD operation to perform.
     */
    SGAction getAction()

    // CallData //

    /**
     * @param callData Data to pass tp the service.
     * @return self.
     */
    SGRequest callData(SGJson callData)

    /**
     * @return JSON data for the service to act on.
     */
    SGJson getCallData()

}
