package se.natusoft.seagull

import groovy.transform.CompileStatic
import se.natusoft.lic.annotation.BinariesAvailableAt
import se.natusoft.lic.annotation.Human_Software_License_1_0
import se.natusoft.lic.annotation.SourceAvailableAt
import se.natusoft.seagull.exceptions.SGException
import se.natusoft.seagull.exceptions.SGNotFoundException

@Human_Software_License_1_0
@SourceAvailableAt( "https://github.com/tombensve/Seagull" )
@BinariesAvailableAt( "https://repo.repsy.io/mvn/tombensve/natusoft-os/" )
/*
# About
About me and my repos.

I have had a lot of fun over the years doing hobby projects here. I have clearly not been stimulated enough at work, so that I have been doing projects for fun here!

I'd like to say that I will keep coding here until they put me in a coffin, and that I'd like to take my computer with me for future archaeologist to scratch their heads at, and I will for as long as I can, and maybe some weird incomprehensible stuff after I no longer can.

I have early onset dementia and are walking on the road to Alzheimer's! I'm thereby no longer working. So why am I telling this here ? Because dementia is a serious thing, that affects too many people! Todays high stress world are partly responsible for this. Definately in my case. I have delivered even if it was impossible! High stress is a really dangerous thing! Is it really worth it ? I'd say NO.

I will continue coding here on Github for as long as I can, these days at my pace
without a deadline, just something I do because I enjoy it, and it keeps stimulating my
brains which is good for me. The brain is a muscle that needs exercise!

In Sweden unfortunately, and definitely in America, which is now a dick-tator-ship, too many people are just carrying their brain around, not usining it! As as a person with dementia I'm offended!

 */
/////////////////////////////////////////////////////////////////////////
// If anyone wonders about the "//...."  it is because IDEA fucks this //
// up royally!!! I thereby have to do this myself.                    //
////////////////////////////////////////////////////////////////////////

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
class SGID {
    
    /**
     * Goes out to all services.
     *
     * To receive broadcasts you need to register as a listener on this ServiceId.
     */
    static SGID Broadcast = register( "SGTarget", "se.natusoft.seagull",
            "Broadcast" )

//.....................................................................................
    
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

//.....................................................................................
    
    /**
     * Holds all registered entries!
     *
     * Do note that this cannot be initialized with a Map here! This
     * has to be done in constructor.
     */
    private static Map<String, SGID> REGISTRY

//.....................................................................................
    
    /**
     * Looks up an SGID.
     *
     * @param idString
     * @return SGID object.
     */
    static SGID fromIdKey( String idString ) {
        
        SGID sgid = REGISTRY.get( idString )
        
        if ( sgid == null )
            throw new SGNotFoundException( "$idString is not valid!" )
        return sgid
    }

//.....................................................................................
    
    /**
     * Holds the key in the map for this specific instance.
     */
    private String idKey

//.....................................................................................
    
    /**
     * Internal constructor.
     *
     * @param type The type of this id.
     * @param owner Use like package in java to avoid collisions.
     * @param id A unique id within the group.
     */
    private SGID( String type, String owner, String id ) {
        
        if ( REGISTRY == null )
            REGISTRY = [ : ]
        
        this.idKey = "${ type }:${ owner }:${ id }"
        
        if ( REGISTRY.containsKey( idKey ) )
            throw new SGException( "SGId:${ idKey } already exists!" )
        
        REGISTRY.put( idKey, this )
    }

//.....................................................................................
    
    /**
     * @return a String representation of the key string.
     */
    String toString() {
        this.idKey
    }

//.....................................................................................
    
    /**
     * Provides equals method.
     *
     * @param id The id to compare to.
     *
     * @return true or false.
     */
    boolean equals( SGID id ) {
        this.idKey == id.toString( )
    }
}
