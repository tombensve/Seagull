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
 *         2023-11-20: Created!
 *         
 */
package se.natusoft.seagull.api

// TODO: Possibly remove!
import groovy.transform.CompileStatic

 /**
  * Enum of valid operations. Basic CRUD!
  *
  * Even though communication protocol is resolved elsewhere I decided to
  * use this from REST/HTTP since it makes a lot of sense.
  */
@CompileStatic
enum  SGOperation {
    CREATE,
    READ,
    UPDATE,
    DELETE,

    OTHER // Unspecific.
}
