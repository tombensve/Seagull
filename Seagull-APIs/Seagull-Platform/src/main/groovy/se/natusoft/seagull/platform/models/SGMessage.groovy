/* 
 * 
 * PROJECT
 *     Name
 *         Seagull-SPlatform
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
import se.natusoft.docutations.DOC_NotNull
import se.natusoft.docutations.DOC_Nullable
import se.natusoft.tools.modelish.Modelish
import se.natusoft.tools.modelish.ModelishModel
import se.natusoft.tools.modelish.ModelishProperty

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
@CompileStatic
interface SGMessage extends SGModel<SGMessage> {

    // No empty messages!
    static final Map<String, Object> DEF_CONTENT = ["Oops!": "No content provided!"] as Map<String, Object>

    /**
     * Convenience! Use: SGMessage msg = SGMessage.FACTORY.setMessageType("MorseCode")....
     */
    static final SGMessage FACTORY = Modelish.create(SGMessage.class)
            .setMessageId(UUID.randomUUID().toString())
            .setContent(DEF_CONTENT)

    //                               PROPERTIES                                             //
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ //

    @ModelishProperty(name = "messageType", desc = "Identifies the content.")
    setMessageType(String type)

    getMessageType()

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ //

    @DOC_NotNull
    @ModelishProperty(name = "messageId", desc = [
            "This should be set when sending a request message. The reply to",
            "that message should have the same id. Other than that they are unique.",
            "Consider using an UUID in string format."
    ])
    SGMessage setMessageId(String id)

    String getMessageId()

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ //

    @DOC_Nullable("If you don't expect a response!")
    @ModelishProperty(name = "responseToId", desc = [
            "If this is a response message this will contain the id of the sent message ",
            "this is a response to. This will be  null if not a response!"
    ])
    void setResponseToId(String id)

    String getResponseToId()

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ //

    @DOC_NotNull
    @ModelishProperty(name = "operation", desc = "Create / Read / ...")
    SGMessage setOperation(SGOperation operation)

    SGOperation getOperation()

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ //

    @DOC_NotNull
    @ModelishProperty(
            name = "content",
            desc = [
                    "The service functional message content. Do note that it is possible to do",
                    "'._toMap() on a Modelish model.",
                    "",
                    "You can also create a model from a Map:",
                    "Modelish.createFromMap( User.class as Class<Model>, userMap )"
            ]
    )
    SGMessage setContent(Map<String, Object> content)

    Map<String, Object> getContent()
}
