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

    /**
     * @param typeId A unique "name" of a message type this represents.
     */
    SGMessageType typeId(String typeId)
    String getTypeId()

    /**
     * @param version The version of this message type.
     */
    SGMessageType version(float version)
    float getVersion()

    /**
     * @param backwardsCompatible A float indicating version it is backwards compatible to.
     */
    SGMessageType backwardsCompatible(float to)
    float isBackwardsCompatible()
}
