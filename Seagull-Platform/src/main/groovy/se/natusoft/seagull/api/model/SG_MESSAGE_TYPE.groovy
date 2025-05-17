package se.natusoft.seagull.api.model

enum SG_MESSAGE_TYPE {

    /**
     * This will always have a response, even if it is just an acknowledgement!
     */
    REQUEST,

    /**
     * This is just a message being sent and nothing more. That said messages can
     * be send as a response to something, but in this case there is nothing waiting
     * for an explicit response. That is there will be no connection between sending
     * and possibly getting another message as a result. Code wise a message should
     * always be treated as a message even if it is sent as a result of another
     * message.
     */
    MESSAGE

}
