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
package se.natusoft.seagull.platform

import groovy.transform.CompileStatic
import se.natusoft.docutations.Note
import se.natusoft.seagull.platform.models.SGRequest
import se.natusoft.seagull.platform.models.SGResponse
import se.natusoft.seagull.platform.models.SGMessageId

/**
 * <p>
 *   This is an API for each Seagull service to use for providing service and for
 *   calling other services. Its intent is to be as easy/trivial as possible!
 *   That is, there is not a ton of options!
 * </p>
 * <p>
 *   An instance of an implementation of this will be provided to each SGService implementation.
 * </p>
 */
@CompileStatic
interface SGPlatform {

    /**
     * This should be used to provide a service.
     *
     * @param serviceName Name of service to register.
     * @param version The version of the service. Different versions can co-exist.
     * @param backwardsCompatible true if current version is backwards compatible.
     *        You should always strive for being backwards compatible. This is for
     *        cases where that is not possible.
     * @param handler
     */
    void registerService(
            SGMessageId sgServiceId,
            Closure<SGMessageId> serviceHandler
    )

    /**
     * Unregisters a service from being available.
     *
     * @param serviceReg The same SGServiceReg passed to registerService(...).
     */
    void unregisterService(
            SGMessageId serviceReg
    )

    /**
     * Calls a service
     *
     * @param sgRequest Data for the service call.
     */
    @Note("I really tried to avoid the terms 'request' and 'response', but I failed!!")
    SGResponse callService(SGRequest sgRequest)

}
