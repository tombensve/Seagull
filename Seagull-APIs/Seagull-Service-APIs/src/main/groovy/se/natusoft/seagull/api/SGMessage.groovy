package se.natusoft.seagull.api

/**
 * This defines the structure sent and received.
 *
 * The intention with this is to add flexibility for future changes
 * without affecting actual messages.
 *
 * This can be updated without affecting actual messages being sent and
 * received between services.
 */
interface SGMessage extends SGModel<SGMessage> {

    /**
     * @param from  Who is sending. Name of service!
     *
     * @return self.
     */
    SGMessage from(String from)
    String from()

    /* _______________________________________________________________________________ */

    /**
     * @param to  Who should receive this.
     *
     * @return self.
     */
    SGMessage to(String to)
    String to()

    /* _______________________________________________________________________________ */

    /**
     * Sets the message content.
     *
     * @param message  The content to set.
     *
     * @return self.
     */
    SGMessage content(SGModel content)
    SGModel content()
}
