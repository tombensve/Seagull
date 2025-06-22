package se.natusoft.seagull.api.internal.services

import se.natusoft.lic.annotation.BinariesAvailableAt
import se.natusoft.lic.annotation.Human_Software_License_1_0
import se.natusoft.lic.annotation.SourceAvailableAt

@Human_Software_License_1_0
@SourceAvailableAt("https://github.com/tombensve/")
@BinariesAvailableAt("https://repo.repsy.io/mvn/tombensve/natusoft-os/")

/**
 * Seagull uses another of my tools, Modelish, which uses interfaces
 * to create Java bean setters and getters and provides a dynamic
 * implementation of the interfaces, and supports immutability and
 * cloning. Internally data is stored in Map<String, Object> structures
 * just like JSON structures.
*/
interface SGJsonMapConverter extends SGExternalWrapper {

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
    String toJSON(Map<String, Object> modelMap)

    /**
     * This takes a JSON String and converts it to a Map
     * structure.
     *
     * @param json The JSON to convert to a Map.
     *
     * @return A converted Map.
     */
    Map<String, Object> toMap(String json)
}
