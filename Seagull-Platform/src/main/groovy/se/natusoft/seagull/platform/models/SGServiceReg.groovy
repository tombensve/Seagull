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
package se.natusoft.seagull.platform.models

import groovy.transform.CompileStatic
import se.natusoft.tools.modelish.Cloneable

/**
 * Modelish model representing a specific service registration for registering
 * Seagull services.
 *
 * This is provided to each SGService implementation.
 *
 * Created like this: `SgServiceReg sgSvcReg = Modelish.create(ShServiceReg.class).serviceName("qaz")...`
 */
@CompileStatic
interface SGServiceReg extends Cloneable<SGServiceReg> {

    /** Sets name of the service */
    SGServiceReg setServiceName(String name)

    /** Gets the name of the service. */
    String getServiceName()

    /** sets the version of the service. */
    SGServiceReg setServiceVersion(float serviceVersion)

    /** Gets the name of the service. */
    float getServiceVersion()

    /** Sets the backwards compatible flag of the service. */
    SGServiceReg setBackwardsCompatible(boolean backwardsCompatible)

    /** Returns the backwards compatible flag of the service. */
    boolean getBackwardsCompatible()
}
