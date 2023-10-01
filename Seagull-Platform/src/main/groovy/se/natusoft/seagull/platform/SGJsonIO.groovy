package se.natusoft.seagull.platform

import groovy.transform.CompileStatic
import se.natusoft.docutations.Singleton
import se.natusoft.seagull.internal.SGProviderLookup
import se.natusoft.seagull.platform.tools.SGJson

/**
 * Since the API is made out of mostly interfaces, this class will provide
 * factory methods providing implementing instances of the interfaces. So whatever
 * factory implementation is available on the classpath will determine what
 * instances are returned. In any and all cases they will be implementations
 * of the declared API, and as user of them you should not care about the
 * implementations.
 */
@CompileStatic
@Singleton
interface SGJsonIO {

    /**
     * This instance will be provided by what ever implementation is available on
     * the classpath at runtime.
     */
    static SGJsonIO use = SGProviderLookup.find( SGJsonIO.class )


    /**
     * Read JSON.
     *
     * @param stream The stream to read from.
     *
     * @return read JSON as Map<String, Object>.
     */
    SGJson read( InputStream stream )


    /**
     * Write JSON from a Map representation.
     *
     * @param json The JSON content Map to write.
     * @param stream The stream to write to.
     */
    void write( SGJson json, OutputStream stream )

    /**
     * Converts the SGJson object into a String of JSON.
     *
     * @param SGJson sgJson
     *
     * @return String
     */
    String toString( SGJson sgJson )
}
