package se.natusoft.seagull.api

import groovy.transform.CompileStatic
import se.natusoft.seagull.base.SGLocalService
import se.natusoft.seagull.api.models.SGJson

/**
 * Transforms between APS Map JSON and real JSON.
 */
@CompileStatic
interface JsonConverter extends SGLocalService {

    /**
     * Takes real JSON from input stream and returns an SGJson object.
     *
     * @param is The InputStreamn to read from.
     *
     * @return An SGJson.
     */
    SGJson fromJSON( InputStream is )

    /**
     * Takes a real JSON as a String and prodcues an SGJson.
     *
     * @param json The JSON String to convert.
     *
     * @return An SGJson.
     */
    SGJson fromString( String json )

    /**
     * Takes and SGJson and returns real JSON as a String.
     *
     * @param apsJson The SGJson to convert.
     *
     * @return A String of JSON.
     */
    String toJson( SGJson apsJson )

    /**
     * Takes an SGJson and writes as real JSON to an OutputStream.
     *
     * @param apsJson The SGJson to write.
     * @param OutputStream The OutputStreamn to write to.
     */
    void writeJson( SGJson apsJson, OutputStream )
}

