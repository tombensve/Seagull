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
 *         2023-11-04: Created!
 *         
 */
package se.natusoft.seagull.platform.tools

import groovy.transform.CompileStatic
import se.natusoft.docutations.Singleton
import se.natusoft.seagull.internal.SGProviderLookup
import se.natusoft.seagull.platform.SGJson

/**
 * Since the API is made out of mostly interfaces, this class will provide
 * factory methods providing implementing instances of the interfaces. So whatever
 * factory implementation is available on the classpath will determine what
 * instances are returned. In any and all cases they will be implementations
 * of the declared API, and as user of them you should not care about the
 * implementations.
 */
@CompileStatic
@Singleton
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
    SGJson read(InputStream stream)


    /**
     * Write JSON from a Map representation.
     *
     * @param json The JSON content Map to write.
     * @param stream The stream to write to.
     */
    void write(SGJson json, OutputStream stream)

    /**
     * Converts the SGJson object into a String of JSON.
     *
     * @param SGJson sgJson
     *
     * @return String
     */
    String toString(SGJson sgJson)
}
