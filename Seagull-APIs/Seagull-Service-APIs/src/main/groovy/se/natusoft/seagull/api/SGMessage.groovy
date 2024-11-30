package se.natusoft.seagull.api

import se.natusoft.lic.annotation.Apache_Software_License_2_0


/**
 * This defines the structure sent and received.
 *
 * The intention with this is to add flexibility for future changes
 * without affecting actual messages.
 *
 * This can be updated without affecting actual messages being sent and
 * received between services.
 */
@Apache_Software_License_2_0
interface SGMessage extends SGModel<SGMessage> {

    /**
     * @param from  Who is sending. Name of service!
     *
     * @return self.
     */
    SGMessage from(String from)
    String from()

    /**
     * @param to  Who should receive this.
     *
     * @return self.
     */
    SGMessage to(String to)
    String to()

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
