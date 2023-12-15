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
package se.natusoft.seagull.platform.factories

import groovy.transform.CompileStatic
import se.natusoft.docutations.Note
import se.natusoft.docutations.Singleton
import se.natusoft.seagull.platform.SGJson
import se.natusoft.seagull.platform.SGProviderLookup

/**
 * Provides a factory for creating SGJson instances.
 */
@CompileStatic
@Singleton
@Note([
        "All models are interfaces based on my 'Modelish' project which uses interfaces and store data ",
        "internally as a JSON like Map structure which can be fetched and set on models without any copying.",
        "I'm however providing factory classes to create these to add more flexibility for implementations."
])
interface SGJsonFactory {

    static final SGJsonFactory use = SGProviderLookup.find(SGJsonFactory.class) as SGJsonFactory

    /**
     * To create an instance do: `SGJsonFactory.use.newSGJson()`
     *
     * @return a new SGJson instance..
     */
    SGJson newSGJson()

}
