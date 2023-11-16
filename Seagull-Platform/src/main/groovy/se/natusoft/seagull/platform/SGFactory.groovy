/* 
 * 
 * PROJECT
 *     Name
 *         Seagull-Platform
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
package se.natusoft.seagull.platform

import se.natusoft.docutations.Singleton
import se.natusoft.seagull.platform.tools.SGID
import se.natusoft.seagull.platform.tools.SGJsonIO

/**
 * Implementations of this provides own implementations of these objects.
 * This so that different implementations can provide own way of handling these.
 *
 * It will find whatever implementation is available runtime.
 */
@Singleton
interface SGFactory {

    static final use = SGProviderLookup<SGFactory>.find(SGFactory.class)

    // Tools

    /**
     * @return a new instance of SGID.
     */
    SGID newSGID()

    /**
     * @return a new instance of SGJsonIO.
     */
    SGJsonIO newSGJsonIO()

    // JSON

    /**
     * @return a  new SGJson instance.
     * @return
     */
    SGJson newSGJson()
}
