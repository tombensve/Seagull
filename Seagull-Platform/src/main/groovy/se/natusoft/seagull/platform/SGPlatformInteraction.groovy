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
package se.natusoft.seagull.platform

import groovy.transform.CompileStatic
import se.natusoft.seagull.platform.models.SGServiceCall
import se.natusoft.seagull.platform.models.SGServiceReg

// ----------------------------------------------------------------------------------------------- //

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
interface SGPlatformInteraction {

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
            SGServiceReg sgServiceReg,
            Closure<SGServiceReg> handler
    )

    /**
     * Unregisters a service from being available.
     *
     * @param serviceReg The same SGServiceReg passed to registerService(...).
     */
    void unregisterService(
            SGServiceReg serviceReg
    )

    /**
     * Calls a service
     *
     * @param sgServiceCall Data for the service call.
     */
    void callService(SGServiceCall sgServiceCall)
}
