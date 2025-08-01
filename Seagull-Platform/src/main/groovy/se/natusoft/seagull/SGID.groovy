package se.natusoft.seagull

import groovy.transform.CompileStatic
import se.natusoft.lic.annotation.BinariesAvailableAt
import se.natusoft.lic.annotation.Human_Software_License_1_0
import se.natusoft.lic.annotation.SourceAvailableAt
import se.natusoft.seagull.exceptions.SGException

@Human_Software_License_1_0
@SourceAvailableAt("https://github.com/tombensve/")
@BinariesAvailableAt("https://repo.repsy.io/mvn/tombensve/natusoft-os/")

/**
 * This is a special ID that must be unique. It is created using the static method:
 *
 *     `register( String type, Sting group, String id )`
 *
 * The 'group' part should be used in a similar way to java packages. The id should
 * be unique within the group.
 *
 * Internally it is stored as a String! There is also a toString() method defined
 * that returns the string.
 *
 * Services should define a unique SGId and use it to indicate who to call and
 * who is calling. Once created it cannot be deleted!!! This is intentional.
 *
 * Yes, these could be UUID:s, but providing strings like this makes it much
 * easier to read and comprehend exactly what it is. Doing a toString on an
 * SGID makes it very clear.
 */
@CompileStatic
class SGID { // IDEA does not like the spelling here, but only here!

    /**
     * Goes out to all services.
     *
     * To receive broadcasts you need to register as a listener on this ServiceId.
     */
    static SGID Broadcast = register( "SGTarget", "se.natusoft.seagull", "Broadcast" )

    /**
     * Public, static  method to register an SGId.
     *
     * @param type The type of information this represents.
     * @param owner This should be used the same way as java packages! It represents both
     *              the organization and project within organization. This must be unique!
     * @param id A unique id within the group representing a service or something
     *           like the id of broadcast target as defined above.
     *
     * @return a new SGId instance.
     */
    static SGID register( String type, String owner, String id ) {
        new SGID( type, owner, id )
    }


    // --------------------------------------------------------------------------- //

    /**
     * Holds all registered entries!
     *
     * Do note that this cannot be initialized with a Map here! This
     * has to be done in constructor.
     */
    private static Map<String, SGID> REGISTRY

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
    private SGID( String type, String owner, String id ) {
        
        if ( REGISTRY == null ) REGISTRY = [:] // This cannot be done until now!
        
        this.idKey = "${type}:${owner}:${id}"

        if ( REGISTRY.containsKey( idKey ) ) throw new SGException( "This SGId already exists!" )

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
    boolean equals( SGID id ) { this.idKey == id.toString() }
}
