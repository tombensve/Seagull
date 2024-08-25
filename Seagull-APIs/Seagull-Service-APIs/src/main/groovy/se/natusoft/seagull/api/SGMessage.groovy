package se.natusoft.seagull.api

import se.natusoft.seagull.support.SGModel

/**
 * This defines the structure sent and received.
 *
 * The intention with this is to add flexibility for future changes
 * without affecting actual messages.
 *
 * This can be updated without affecting actual messages being sent and
 * received between services.
 */
interface SGMessage extends SGModel<SGMessage>{

    /**
     * @param from who is sending.
     * @return self.
     */
    SGMessage setFrom(String from)
    String getFrom()

    /**
     * @param to Who to send to.
     * @return self.
     */
    SGMessage setTo(String to)
    String getTo()

    /**
     * Sets the message content.
     *
     * @param message The content to set.
     * @return self.
     */
    SGMessage setContent(SGModel message)
    SGModel getContent()
}
