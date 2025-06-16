package se.natusoft.seagull.provider.internal

import se.natusoft.seagull.api.internal.services.SGJsonMapService

class SGJsonMapServiceProvider implements SGJsonMapService {
    /**
     * This takes a Map structure and converts to JSON.
     * It will recursively convert any Map values found
     * to produce a complete JSON structure.
     *
     * @param modelMap The Map to convert to a JSON String.
     *
     * @return A String containing a JSON object including
     *         potential sub JSON objects that exactly
     *         reflects the input Map.
     */
    @Override
    String toJSON( Map<String, Object> modelMap ) {
        return null
    }

    /**
     * This takes a JSON String and converts it to a Map
     * structure.
     *
     * @param json The JSON to convert to a Map.
     *
     * @return A converted Map.
     */
    @Override
    Map<String, Object> toMap( String json ) {
        return null
    }
}
