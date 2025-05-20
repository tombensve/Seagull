package se.natusoft.seagull.api.model

import se.natusoft.docutations.Optional

interface SGCRUDMessage extends SGMessage {

    /**
     * Sets CRUD operation. This fits protocols like REST, but can be useful
     * even with other protocols also.
     *
     * Note 1:  that this is a String! I'm not entirely sure Modelish supports
     * enums (yet). But the SG_CRUD enum can be used with .toString() in
     * the end to get a correct string value.
     *
     * @param crud Provides the CRUD operation requested.
     */
    @Optional
    void setCrud( String crud )

    /**
     * @return The CRUD operation requested.
     */
    @Optional
    String getCRUD()

}
