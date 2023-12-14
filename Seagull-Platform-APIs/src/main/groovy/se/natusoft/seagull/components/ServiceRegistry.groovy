/* 
 * 
 * PROJECT
 *     Name
 *         Seagull-Platform-APIs
 *     
 *     Description
 *         Seagull - Intended to be a very simple service platform.
 *         
 *         The idea here is to define a service platform that says
 *         nothing about how services communicate with each other.
 *         This defines APIs and not to many of those, that can be
 *         implemented with whatever protocol. What protocol is used
 *         depends on what implementation you make available on
 *         the classpath.
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

import se.natusoft.docutations.Description
import se.natusoft.docutations.Note
import se.natusoft.docutations.Property
import se.natusoft.tools.modelish.Cloneable

@Note("All these are data models holding service registration data!")

@Description(

        "Contains known service records."
)
interface ServiceRegistry extends Cloneable<ServiceRegistry> {

    ServiceRegistry serviceRecords(List<ServiceRecord> serviceRecords)

    List<ServiceRecord> getServiceRecords()
}

// --------------------------------------------------------------------------------------------- //

@Description(

        "Where to find the service and how to talk to it."
)
interface SGServiceAvailability extends Cloneable<SGServiceAvailability> {

    @Property(name = "host", desc = "The host the service is running on.")
    SGServiceAvailability host(String host)

    String getHost()

    @Property(name = "port", desc = "The port on the host to talk to the service.")
    SGServiceAvailability port(int port)

    int getPort()

    @Property(name = "protocol", desc = "A hind about the protocol needed to talk to the service.")
    SGServiceAvailability protocol(String protocol)

    String getProtocol()
}


@Description(

        "Represents one specific service in one specific place."
)
interface ServiceRecord extends Cloneable<ServiceRecord> {

    @Property(name = "serviceName", desc = "The name of the service.")
    ServiceRecord serviceName(String name)

    String getServiceName()

    @Property(name = "serviceVersion", desc = "The version of the provided service.")
    ServiceRecord serviceVersion(float version)

    float getServiceVersion()

    @Property(name = "serviceAvailability", desc = "A list of places where the service is available.")
    ServiceRecord serviceAvailability(SGServiceAvailability sgServiceAvailability)

    List<SGServiceAvailability> getServiceAvailability()
}

