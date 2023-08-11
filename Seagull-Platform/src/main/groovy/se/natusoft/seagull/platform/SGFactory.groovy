package se.natusoft.seagull.platform

import se.natusoft.seagull.internal.SGProviderLookup

interface SGFactory {

    /**
     * This instance will be provided by what ever implementation is available on
     * the classpath runtime. So how the implementations are created depends on
     * the factory found.
     */
    static SGFactory use = SGProviderLookup.find(SGFactory.class)

    //
    // JSON
    //

    /**
     * Provides JSON content as a Map structure.
     *
     * @param mapJSON The Map structure to set as content.
     */
    SGJson jsonFromMap(Map<String, Object> mapJSON)

    /**
     * Sets content as JSON string.ß
     *
     * @param json The JSON content to set.
     */
    SGJson jsonFromString(String json)

    /**
     * Reads JSON from provided stream.
     *
     * @param jsonStream The stream to read JSON from.
     */
    SGJson jsonFromInputStream(InputStream jsonStream)

}
