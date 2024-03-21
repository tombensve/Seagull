/* 
 * 
 * PROJECT
 *     Name
 *         Seagull-Platform
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
 *         2023-11-20: Created!
 *         
 */
package se.natusoft.seagull.platform.models

import groovy.transform.CompileStatic

/**
 * This is an enumish that can dynamically be added to at any time. If more constant:ish are added
 * consider doing it in an own extension of this class! It is of course possible to use lookup("name") to
 * get an instance, but it is more readable with a static constant.
 *
 * (American disclaimer: There were no sexual intent what so ever here!)
 */
@CompileStatic
class SGOperation {

    // These are static definitions of default operations. That said, you can create
    // more elsewhere, but you need to save them as constant instances elsewhere.
    static final SGOperation Create = create( "Create" )
    static final SGOperation Read = create( "Read" )
    static final SGOperation Update = create( "Update" )
    static final SGOperation Delete = create( "Delete" )
    static final SGOperation Sync = create( "Sync" )
    static final SGOperation Shutdown = create( "Shutdown" )

    // ================================================================================== //

    private static final Map<String, SGOperation> OPS = new HashMap<String, SGOperation>()

    /**
     * Creates a new SGOperation.
     *
     * @param op The operation name.
     */
    protected SGOperation( String op ) {
        OPS.put( op, this )
    }

    /**
     * Creates a new operation.
     *
     * @param name The name of the operation. You need the given name to look it up after creation.
     *
     * @return created operation.
     */
    static SGOperation create( String name ) {
        new SGOperation( name )
    }

    /**
     * Looks up an operation by name.
     *
     * @param name The name of the operation to lookup.
     * @return found operation or null if name does not match anything.
     */
    static SGOperation lookup( String name ) {
        OPS.get( name )
    }

    /**
     * This is more to show how easy it is to compare, which can be done directly rather
     * than call this.
     *
     * @param o1 first operation to compare for equality.
     * @param o2 second operation to compare for equality
     * @return true or false.
     */
    static boolean compare( SGOperation o1, SGOperation o2 ) {
        o1 == o2
    }
}
