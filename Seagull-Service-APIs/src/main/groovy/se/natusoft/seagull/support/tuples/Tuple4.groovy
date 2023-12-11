/*
 *
 * PROJECT
 *     Name
 *         Seagull-Service-APIs
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
 *     Tommy Svensson (tommy@natusoft.se)
 *         Changes:
 *         2014-03-08: Created!
 *
 */
package se.natusoft.seagull.support.tuples

import groovy.transform.CompileStatic

/**
 * A tuple with four values.
 */
@CompileStatic
class Tuple4<T1, T2, T3, T4> extends Tuple3<T1, T2, T3> {

    T4 t4

    Tuple4() {}

    Tuple4(T1 t1, T2 t2, T3 t3, T4 t4) {
        super.t1 = t1
        super.t2 = t2
        super.t3 = t3
        this.t4 = t4
    }
}
