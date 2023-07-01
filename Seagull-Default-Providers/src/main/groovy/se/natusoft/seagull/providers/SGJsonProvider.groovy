package se.natusoft.seagull.providers

import com.google.auto.service.AutoService
import groovy.transform.CompileStatic
import se.natusoft.seagull.api.models.SGJson

/**
 * Provides an implementation of SGJson.
 */
@CompileStatic
@AutoService
class SGJsonProvider extends LinkedHashMap<String, Object> implements SGJson {

    /**
     * Creates a new SGJsonProvider.
     */
    SGJsonProvider() {}


    /**
     * Adds a JSON Map to this object.
     *
     * @param json The JSON Map tp add.
     */
    void setJson(Map<String, Object> json) {

        super.clear(  )
        super.putAll( json )
    }

    /**
     * Writes this JSON object as JSON to specified stream.
     *
     * @param OutputStream The OutputStreamn to write to.
     */
    void write( OutputStream ) {

    }
}
