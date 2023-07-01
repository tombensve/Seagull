package se.natusoft.seagull.api.models

import groovy.transform.CompileStatic

/**
 * Internally we treat JSON as Map<String, Object>. Jackson Jr can translate between Map<String, Object> and
 * actual JSON. Groovys JSONSlurper can also handle this format, but I've heard that JSONSlurper has some
 * bugs, which is why I stick to Jackson Jr.
 */
@CompileStatic
interface SGJson extends Map<String, Object> {

    /**
     * @return content as a String.
     */
    String toString()

    /**
     * Writes this JSON object as JSON to specified stream.
     *
     * @param OutputStream The OutputStreamn to write to.
     */
    void write( OutputStream )
}


