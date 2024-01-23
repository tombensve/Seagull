/* 
 * 
 * PROJECT
 *     Name
 *         Seagull-Internal-APIs
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
import se.natusoft.seagull.exceptions.SGNotFoundException
import se.natusoft.seagull.platform.SGAPIProviderLookup
import se.natusoft.seagull.platform.models.SGMessage

@CompileStatic

/**
 * This is the one that knows about local and remote services! It can take a call and
 * pass it on to the best destination.
 *
 * This is internal API, users if Seagull will never see this! Thereby this not an absolute
 * requirement to use. This just reflects my thinking in how to implement this.
 *
 * - Keeps track of local services.
 * - Keeps track of remote services.
 * - Keeps track of master router, which can be self!
 */
interface SGRouter {
    SGRouter use = SGAPIProviderLookup.find(SGRouter.class)

    /**
     * Routes a call to a place where the service is available. This should
     * first look locally in same JVM instance for the service, and if not
     * found there call another instance on the network.
     *
     * @param serviceCall A SGServiceCall instance containing all information needed to do the call
     *                    independent of actual protocol used over the network.
     */
    SGMessage routeCall(SGMessage serviceCall) throws SGNotFoundException

    /**
     * @return true if this specific router instance is the master router. This status should be supplied
     * by configuration. There should be only one master!!
     */
    boolean isMaster()

}
