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
import se.natusoft.tools.modelish.Cloneable
import se.natusoft.tools.modelish.ModelishModel

@CompileStatic

/**
 * Modelish model representing a specific message. Note that this does not in any way
 * define the structure of the message! It only provides a unique type name, and version of it
 * since it might change over time.
 */
@ModelishModel
interface SGMessageType extends Cloneable<SGMessageType> {

    default final SGMessageType create() { SGFactory.use.newSGMessageType() }

    /**
     * Try to make these quite unique! For example: "se.natusoft:MyService:User", that is include domain, or
     * something other that will decrease chance of overlap. A String UUID will work, though it is
     * good to have a name that makes sense.
     *
     * This is just an identification of what sent/received data looks like, but without having it
     * defined in code. Such has to be documented somewhere and code that reads the _typeId_ need to
     * know the contents structure implicitly from the name. A version is also supplied below to
     * support multiple versions of the message.
     *
     * It is of course possible to define interface models like this one for each message type!
     * I'm just not making it an absolute requirement. That would be rather messy. That said I would
     * personally create models for my clients and services to use for cleaner and more readable
     * code.
     *
     * In Groovy this information could also be provided as:
     * ["id": "SampleType", "version":1.2f, "backwardsCompatible":true]
     *
     * Also note that Seagull says nothing about protocol, how messages are transferred over the
     * network! That is up to an implementation to decide. All services thereby need to use same
     * implementation to talk to each other!
     *
     * @param id A unique "name" of a message type this represents.
     */
    SGMessageType setId(String id)
    String getId()

    /**
     * @param version The version of this message type.
     */
    SGMessageType setVersion(float version)
    float getVersion()

    /**
     * @param backwardsCompatible A float indicating version it is backwards compatible to.
     */
    SGMessageType setBackwardsCompatible(boolean backwardsCompatible)
    boolean isBackwardsCompatible()
}
