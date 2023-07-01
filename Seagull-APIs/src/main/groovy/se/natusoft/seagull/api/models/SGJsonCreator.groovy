package se.natusoft.seagull.api.models

import se.natusoft.docutations.Atheist
import se.natusoft.docutations.Singleton
import se.natusoft.seagull.api.internal.SGLocalServiceFinder

/**
 * Factory for creating SGJson objects.
 */
@Singleton( desc = "Always access via the 'use' constant." )
@Atheist
interface SGJsonCreator {

    /** Provides the singleton  instance. */
    static final SGJsonCreator use = SGLocalServiceFinder.find( SGJsonCreator.class )

    /**
     * Creates a new empty SGJson instance.
     */
    SGJson create()

    /**
     * Creates a new SGJson with content.
     *
     * @param data The content to add.
     */
    SGJson create( Map<String, Object> data )

}
