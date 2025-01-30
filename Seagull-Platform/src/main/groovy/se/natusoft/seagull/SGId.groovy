package se.natusoft.seagull

import groovy.transform.CompileStatic
import se.natusoft.lic.annotation.Apache_Software_License_2_0
import se.natusoft.seagull.exceptions.SGException

/**
 * This is a special ID that must be unique. It is created using the static method:
 *
 *     `register( Sting group, String id )`
 *
 * The 'group' part should be used in a similar way to java packages. The id should
 * be unique within the group.
 *
 * Internally it is stored as a String! There is also a toString() method defined
 * that returns the string.
 */

@Apache_Software_License_2_0
@CompileStatic
class SGId {

    /**
     * Goes out to all services.
     *
     * To receive broadcasts you need to register as a listener on this ServiceId.
     */
    static SGId Broadcast = register( "SGTarget" , "se.natusoft.seagull", "Broadcast" )

    // --------------------------------------------------------------------------- //

    /** Holds all registered entries */
    private static Map<String, SGId> REGISTRY

    /**
     * Holds the key in the map for this specific instance.
     */
    private String idKey

    /**
     * Internal constructor.
     *
     * @param type The type of this id.
     * @param owner Use like package in java to avoid collisions.
     * @param id A unique id within the group.
     */
    private SGId( String type,  String owner, String id) {

        if (REGISTRY == null) REGISTRY = [ : ]


        this.idKey = "${type}:${owner}:${id}"

        if (REGISTRY.containsKey( idKey ) ) throw new SGException("This SGId already exists!")

        REGISTRY.put( idKey, this )
    }


    /**
     * @return a String representation of the key string.
     */
    String toString() {
        this.idKey
    }


    /**
     * Provides equals method.
     *
     * @param id The id to compare to.
     *
     * @return true or false.
     */
    boolean equals( SGId id ) {
        this.idKey == id.toString()
    }


    /**
     * Public, static  method to register an SGId.
     *
     * @param type The type of information this represents.
     * @param group This should be used the same way as java packages! It represents both
     *              the organization and project within organization. This must be unique!
     * @param id A unique id within the group representing a service or something
     *           like the id of broadcast target as defined above.
     *
     * @return a new SGId instance.
     */
   static SGId register( String type, String group, String id ) {
        new SGId( type, group, id)
    }

}
