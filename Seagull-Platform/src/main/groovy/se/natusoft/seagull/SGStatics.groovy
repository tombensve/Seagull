package se.natusoft.seagull

import se.natusoft.seagull.api.SGProtocol

/**
 * Holds static data provided at startup.
 */
interface SGStatics {

    /** These properties are accessible from anywhere in the code. */
    static final Properties startupProps = new Properties()

    /** Holds all found protocols. */
    static final Map<String, SGProtocol> protocols = [ : ]


}
