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
 *     tommy
 *         Changes:
 *         2023-11-04: Created!
 *         
 */
package se.natusoft.seagull.platform

import groovy.transform.CompileStatic

/**
 * Each Seagull "service" will implement this interface and it should be annotated with
 * googles @AutoService, unless you prefer doing it the hard way ...
 *
 * To be very clear, each Seagull service provider will implement this interface
 * and receive the SGServiceInteraction which it will use to register and unregister
 * services.
 */
@CompileStatic
interface SGServiceLifecycle {

    /**
     * Initializes the service and provides an instance of SGPlatform which is used to interact
     * with the Seagull platform. Called on startup, and the sgPlatform instance should be saved
     * locally.
     *
     * @param sgPlatform Used to call services and receive calls for service providers.
     *        This should thereby be cached locally.
     */
    void startup(SGPlatform sgPlatform)

    /**
     * Called on shutdown. Any needed cleanup should be done here.
     */
    void shutdown()

}
