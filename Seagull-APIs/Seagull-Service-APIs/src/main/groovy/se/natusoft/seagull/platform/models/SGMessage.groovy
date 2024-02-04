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
 *         2023-11-04: Created!
 *         
 */
package se.natusoft.seagull.platform.models

import groovy.transform.CompileStatic

import se.natusoft.tools.modelish.Cloneable
import se.natusoft.tools.modelish.ModelishModel

@CompileStatic

/**
 * Represents data needed to call a service.
 *
 * Each service has its own "type" name, that it takes as input, and one that it
 * sends in response. So the type of the sent message actually identifies a service
 * to process it. The reply message however can be same for multiple services.
 *
 * All messages are JSON structures! Both internal and actual service messages.
 * All messages will have the below defined structure, and the "content" is a
 * pure JSON structure that can be handled any way you want. That said, this message
 * model and others makes use of [Modelish](https://github.com/tombensve/NS-Toolbox/tree/main/Modelish),
 * which internally stores things as Map<String, Object> JSON like structure, which
 * can relatively easy be converted to JSON. So it is possible to make a Modelish
 * model of the JSON content also. This API will however deliver it as a
 * ` Map<String,Object>`, but this can be set on a Modelish model reflecting
 * the same structure. Seagull leaves this upp to implementations to handle.
 */
@ModelishModel
interface SGMessage extends Cloneable<SGMessage> {

    default final SGMessage create() { SGFactory.use.newSGMessage() }

    /**
     *
     * @param messageType  A unique type name identifying the message content, how to interpret it.
     */
    SGMessage setType(SGMessageType messageType)
    SGMessageType getType()

    /**
     * @param id This should be set when sending a request message. The reply to
     *           that message should have the same id. Other than that they are unique.
     *           Consider using an UUID in string format.
     */
    SGMessage setId(String id)
    String getId()

    /**
     * When broadcast is true then a call will be made to every known instance of that service, and
     * every called service will possibly have a response. Each response will then be returned as a
     * List of responses.
     *
     * Actually all responses should be a List, and in most cases there will only be one
     * entry in it. So if broadcast is true there might be more than one response.
     * Implementations must be able handle this. The KISS rule applies!!
     *
     * @param broadcast If true then message will be sent to all services found listening to the message type.
     */
    SGMessage setBroadcast(boolean broadcast)
    boolean isBroadcast()

    // I don't like this name, but have not been able to come up with something better!
    /**
     * The action to for the call to perform.
     */
    SGMessage setAction(SGMessageAction action)
    SGMessageAction getAction()

    /**
     * The actual message content.
     */
    SGMessage setContent(SGJson content)
    SGJson getContent()
}
