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
package se.natusoft.seagull.tools

import groovy.transform.CompileStatic
import se.natusoft.lic.annotation.Apache_Software_License_2_0
import se.natusoft.seagull.api.SGJson

/**
 * This reads and writes JSON, and converts between Strings containing JSON and SGJson.
 */
@CompileStatic
@Apache_Software_License_2_0
interface SGJsonIO {

    /**
     * This instance will be provided by what ever implementation is available on
     * the classpath at runtime.
     */
    static SGJsonIO use = SGProviderLookup.find(SGJsonIO.class)

    /**
     * Read JSON.
     *
     * @param stream The stream to read from.
     *
     * @return read JSON as Map<String, Object>.
     */
    SGJson readJSon( InputStream stream)

    /* _______________________________________________________________________________ */

    /**
     * Write JSON..
     *
     * @param json The JSON content Map to write.
     * @param stream The stream to write to.
     */
    void writeJSON(SGJson json, OutputStream stream)

}
