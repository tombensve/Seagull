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
 *         2023-12-05: Created!
 *         
 */
package se.natusoft.seagull.internals

import groovy.transform.CompileStatic
import se.natusoft.docutations.DOC_Optional
import se.natusoft.seagull.platform.models.SGModel
import se.natusoft.tools.modelish.ModelishModel
import se.natusoft.tools.modelish.ModelishProperty

/**
 * Represents information about a specific service.
 *
 * This model is a way to represent a service from implementation perspective.
 */
@DOC_Optional
@ModelishModel
@CompileStatic
interface ServiceRecord extends SGModel<ServiceRecord> {

    // ≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈ //

    @ModelishProperty(name = "serviceName")
    ServiceRecord setServiceName(String name)

    String getServiceName()

    // ≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈ //

    @ModelishProperty(name = "serviceVersion")
    ServiceRecord setServiceVersion(float version)

    float getServiceVersion()

    // ≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈ //

    @ModelishProperty(name = "serviceLocations",
            desc = [
                    "The URL type is just used to hold information. If the service uses an URL",
                    "then its an URL! If not both host and port and protocol can be specified,",
                    "no matter how connections actually are made. A URL can actually be used",
                    "to connect to any host/port no matter what data is transmitted over the",
                    "connection! So don't read to much into this URL!"
            ])
    ServiceRecord setServiceLocations(List<URL> serviceLocations)

    List<URL> getServiceLocations()

    // ≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈ //
}
