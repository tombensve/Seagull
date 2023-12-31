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
 *         2023-12-05: Created!
 *         
 */
package se.natusoft.seagull.components

import groovy.transform.CompileStatic
import se.natusoft.docutations.DT_InternalAPI
import se.natusoft.tools.modelish.Cloneable

/**
 * Model for a specific service record.
 */
@CompileStatic
@DT_InternalAPI
interface ServiceRecord extends Cloneable<ServiceRecord> {

    /**
     * Provides a name of the service.
     *
     * @param name The name to set.
     *
     * @return self.
     */
    ServiceRecord serviceName(String name)

    /**
     * @return Service name.
     */
    String getServiceName()

    /**
     * Sets the version of the service.
     *
     * @param version The version to set.
     *
     * @return self.
     */
    ServiceRecord serviceVersion(float version)

    /**
     * @return The service version.
     */
    float getServiceVersion()

    /**
     * Provides a set of locations where service is running.
     *
     * Do note here that depending on implementations an URL might not be usable. But it sits on information
     * that can be extracted and used to a TCP connection.
     *
     * @param serviceLocations Provides a set of service locations, or an empty list.
     *
     * @return self.
     */
    ServiceRecord serviceLocations(List<URL> serviceLocations)

    /**
     * @return List of URLs to where service is available.
     */
    List<URL> getServiceLocations()
}
