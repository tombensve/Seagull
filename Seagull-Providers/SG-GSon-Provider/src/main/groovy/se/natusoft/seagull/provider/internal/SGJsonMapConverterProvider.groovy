package se.natusoft.seagull.provider.internal

import com.google.common.reflect.TypeToken
import com.google.gson.Gson
import se.natusoft.seagull.api.internal.services.SGJsonMapConverter
import java.lang.reflect.Type

/**
 * This converts between JSON in strings and Map<String, Object> structures.
 * The latter can be used as data provider for a Modelish model.
 */
class SGJsonMapConverterProvider implements SGJsonMapConverter {

    /** Static GSon instance. */
    private static  Gson gson = new Gson()

    /** static declaration of Map<String, Object) type. */
    private static Type MapType = new TypeToken<Map<String, Object>>(){}.getType()

    /**
     * This takes a Map structure and converts to JSON.
     *
     * @param modelMap The Map to convert to a JSON String.
     *
     * @return A String containing a JSON object including
     *         potential sub JSON objects that exactly
     *         reflects the input Map.
     */
    @Override
    String toJSON( Map<String, Object> modelMap ) {

        gson.toJson( modelMap, MapType)
    }

    /**
     * This takes a JSON String and converts it to a Map
     * structure.
     *
     * @param json The JSON to convert to a Map structure.
     *
     * @return A Map with eventual sub Maps reflecting original JSON structure.
     */
    @Override
    Map<String, Object> toMap( String json ) {

        gson.fromJson(json, MapType)
    }
}
