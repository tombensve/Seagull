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

@CompileStatic

/**
 * I like to have a JSON object that represents a JSON structure. That said, this is
 * just a `Map<String, Object>` and can be treated as such. The actual implementation
 * is handled by LinkedHashMap.
 *
 * In other words, this is just cosmetics :-). But I do think that "SGJson" looks much
 * better as a type than "Map<String, Object>" does!
 */
class SGJson extends LinkedHashMap<String, Object> implements Map<String, Object> {

    /**
     * 'Creates a new, empty SGJson instance.
     */
    SGJson() {}

    /**
     * Creates a new SGJson with provided data.
     *
     * @param data to include from start.
     */
    SGJson(Map<String, Object> data) {
        this.putAll(data)
    }

    String toString() {
        // TODO: convert JSON structure to actual JSON as a String.
    }

    static SGJson fromString(String json) {
        // TODO: Convert JSON string into map.
    }
}
