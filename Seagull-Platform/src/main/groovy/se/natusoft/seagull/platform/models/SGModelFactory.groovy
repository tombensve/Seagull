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
import se.natusoft.tools.modelish.Modelish

/**
 * Utility for creating argument models. Let any class using this implement this trait.
 */
@CompileStatic
trait SGModelFactory {

    /**
     * Creates the model needed for registering a new Seagull service.
     */
    static SGServiceReg newSGServiceReg() {
        Modelish.create(SGServiceReg.class)
    }

    /**
     * Creates a model instance for making a service call.
     */
    static SGServiceCall newSGServiceCall() {
        Modelish.create(SGServiceCall.class)
    }
}
