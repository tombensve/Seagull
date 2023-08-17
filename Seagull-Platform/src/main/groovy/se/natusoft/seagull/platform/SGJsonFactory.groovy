package se.natusoft.seagull.platform

import groovy.transform.CompileStatic
import se.natusoft.seagull.internal.SGProviderLookup

/**
 * Since the API is made out of mostly interfaces, this class will provide
 * factory methods providing implementing instances of the interfaces. So whatever
 * factory implementation is available on the classpath will determine what
 * instances are returned. In any and all cases they will be implementations
 * of the declared API, and as user of them you should not care about the
 * implementations.
 */
@CompileStatic
interface SGJsonFactory {

    /**
     * This instance will be provided by what ever implementation is available on
     * the classpath runtime.
     */
    static SGJsonFactory use = SGProviderLookup.find(SGJsonFactory.class)

    //
    // JSON
    //

    /**
     * Provides JSON content as a Map structure.
     *
     * @param mapJSON The Map structure to set as content.
     */
    SGJson createJson(Map<String, Object> mapJSON)

    /**
     * Sets content as JSON string.ß
     *
     * @param json The JSON content to set.
     */
    SGJson createJson(String json)

    /**
     * Reads JSON from provided stream.
     *
     * @param jsonStream The stream to read JSON from.
     */
    SGJson createJson(InputStream jsonStream)

}
