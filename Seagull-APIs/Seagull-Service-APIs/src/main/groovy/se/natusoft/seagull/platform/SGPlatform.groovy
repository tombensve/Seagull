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
import se.natusoft.docutations.DOC_Unique
import se.natusoft.seagull.exceptions.SGException
import se.natusoft.seagull.platform.models.SGMessage
import se.natusoft.seagull.platform.models.SGMessageType

@CompileStatic

/**
 *   This is an API for each Seagull service to use for providing service and for
 *   calling other services. Its intent is to be as easy/trivial as possible!
 *   That is, there is not a ton of options!
 *
 *   An instance of an implementation of this will be provided to each SGService implementation.
 *
 */
interface SGPlatform {

    /**
     * This should be used to provide a service.
     *
     * @param serviceName The name of the service.
     * @param messageType The type of the message that this service handles (by name, version).
     * @param serviceProvider The handler of the service, which will produce a return message,
     *        which will be passed back to the caller.
     */
    SGPlatform registerService(
            @DOC_Unique
            String serviceName,

            SGMessageType messageType,

            // Only way to declare both argument and return value!!!
            // Cast a groovy closure that takes and returns an SGMessage.
            // That said, this also allows Java code to call this!
            SGServiceProvider serviceImpl
    )

    /**
     * Unregisters a service from being available.
     *
     * @param serviceReg The same SGServiceReg passed to registerService(...).
     */
    SGPlatform unregisterService(
            SGMessageType messageType
    )

    /**
     * Calls a service
     *
     * @param message Data for the service call.
     */
    SGPlatform sendMessage(SGMessage message, Closure<SGMessage> responseHandler) throws SGException

    /**
     * Calls a service
     *
     * @param message Data for the service call.
     * @param respTimeoutMilli Response timeout.
     * @param responseHandler The handler to call with response.
     */
    SGPlatform sendMessage(SGMessage message, int respTimeoutMilli, Closure<SGMessage> responseHandler)
            throws SGException
}
