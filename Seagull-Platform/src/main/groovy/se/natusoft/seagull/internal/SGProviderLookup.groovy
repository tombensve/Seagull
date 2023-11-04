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
package se.natusoft.seagull.internal

import groovy.transform.CompileStatic

/**
 * <p>
 *     The Seagull-Platform jar mostly defines interfaces. Other jars has to be added
 *     to the classpath that implements these interfaces. This class is used for looking
 *     up an implementation of a specified interface. Javas ServiceLoader is used for this.
 *     All implementations should be annotated with Googles '@AutoService'.
 * </p>
 */
@CompileStatic
class SGProviderLookup<T> {

    /**
     * Provides static method for loading a service specified by its interface class.
     * This currently (and most probably always) returns an instance provided by the
     * Java ServiceLoader class.
     *
     * @param api The interface class to get implementation for.
     *
     * @return An implementation of the API.
     */
    static <T> T find( Class<T> api ) {

        return (T) ServiceLoader.load( api ).findFirst().get()
    }

    /**
     * Provides a static method fore finding all instances of providing implementations of the api.
     *
     * @param api The interface class to get the implementation for.
     *
     * @return All implementations of the API.
     */
    static <T> List<T> findAll( Class<T> api ) {

        return ServiceLoader.load( api ).asList()
    }
}
