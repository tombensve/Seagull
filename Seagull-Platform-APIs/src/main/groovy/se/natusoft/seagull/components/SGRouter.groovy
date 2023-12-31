/* 
 * 
 * PROJECT
 *     Name
 *         Seagull-Platform-APIs
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
 *         2023-11-13: Created!
 *         
 */
package se.natusoft.seagull.components

import groovy.transform.CompileStatic
import se.natusoft.docutations.DT_Singleton
import se.natusoft.seagull.exceptions.SGNotFoundException
import se.natusoft.seagull.platform.SGProviderLookup
import se.natusoft.seagull.platform.models.SGCall
import se.natusoft.seagull.platform.models.SGServiceId

/**
 * This is the one that knows about local and remote services! It can take a call and
 * pass it on to the best destination.
 *
 *   - Keeps track of local services.
 *   - Keeps track of remote services.
 */
@CompileStatic
@DT_Singleton
interface SGRouter {

    /** Singleton instance of implementation. */
    SGRouter use = SGProviderLookup.find(SGRouter.class)

    /**
     * @return All services available locally in same jar. These can be called without going out
     *         on the network.
     */
    List<SGServiceId> localServices()

    /**
     * @return All Seagull services found on the network.
     */
    List<SGServiceId> externalServices()

    /**
     * Passes a call on to a service independent of where the service exists. If an implementation of
     * the service is found locally in same jar file, then that is called. Otherwise a remote call
     * over the network will be done.
     *
     * Again, note that Seagull does not return any data at all! The service handling the call will
     * receive information about the caller, and if there are any information to supply the caller
     * with, the receiver will make a call back to the calling service with that data when available.
     * So there is no make call, wait for response.
     *
     * @param serviceCall An SGServiceCall instance containing all information needed to do the call
     *        independent of actual protocol used over the network.
     */
    void routeCall(SGCall serviceCall) throws SGNotFoundException

}
