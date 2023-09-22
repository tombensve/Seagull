package se.natusoft.seagull.platform

import groovy.transform.CompileStatic

/**
 * Internally we treat JSON as Map<String, Object>. Jackson Jr can translate between Map<String, Object> and
 * actual JSON. Groovys JSONSlurper can also handle this format, but I've heard that JSONSlurper has some
 * bugs, which is why I stick to Jackson Jr.
 */
@CompileStatic
interface SGJson {

    // Note: Internally the JSON should preferably be stored as Map<String, Object>!

    /**
     * @return the content as a string of JSON.
     */
    String toString()

    /**
     * Returns the content as a JSON structured Map.
     *
     * @return
     */
    Map<String, Object> toMap()

    /**
     * Writes this JSON object as JSON to specified stream.
     *
     * @param OutputStream The OutputStreamn to write to.
     */
    void writeJSON(OutputStream)


}


