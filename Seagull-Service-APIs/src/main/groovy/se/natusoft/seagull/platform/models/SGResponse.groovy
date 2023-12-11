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
 *     tommy ()
 *         Changes:
 *         2023-12-05: Created!
 *         
 */
package se.natusoft.seagull.platform.models

import se.natusoft.seagull.platform.SGJson

/**
 * A response to a Seagull request.
 */
interface SGResponse {

    /**
     * @param messageId Provides message type and version of the response.
     *
     * @return self.
     */
    SGRequest messageId(SGMessageId messageId)

    /**
     * @return The id and version of the response message.
     */
    SGMessageId getMessageId()

    /**
     * @param Response data to pass tp the calling service.
     * @return self.
     */
    SGResponse response(SGJson response)

    /**
     * @return JSON data for the service to act on.
     */
    SGJson getResponse()

}
