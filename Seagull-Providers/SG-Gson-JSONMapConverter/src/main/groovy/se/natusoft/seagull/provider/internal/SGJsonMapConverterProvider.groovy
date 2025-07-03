// ---------------------------------------------------------------------------------------
// When using Gson:
// WRONG: import com.google.common.reflect.TypeToken
// RIGHT: import com.google.gson.reflect.TypeToken
//
// Classes that are used by more code than one codebase, should be broken out into
// a library so that all uses the same implementation in same package!
//
// Here we have an object with the same name and probably same functionality, but in
// different packages in different jars! When both are on the CLASSPATH then it is
// probably random which are picked by the IDE.
//
// IDEA out of the blue replaces the correct with the incorrect when both happen
// to be on the CLASSPATH!!!
//
// But it is really Google that is to blame for this!!
// See: https://stackoverflow.com/questions/39138241/gson-typetoken-classnotfoundexception
//
// I was really impressed with Gson and said to my self, these guys really know
// what they are doing! Apparently not!
// ---------------------------------------------------------------------------------------

package se.natusoft.seagull.provider.internal

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import se.natusoft.lic.annotation.BinariesAvailableAt
import se.natusoft.lic.annotation.Human_Software_License_1_0
import se.natusoft.lic.annotation.SourceAvailableAt
import se.natusoft.seagull.api.internal.services.SGJsonMapConverter
import java.lang.reflect.Type

/**
 * This converts between JSON in strings and Map<String, Object>
 * structures. The latter can be used as data provider for a
 * Modelish model.
 *
 * Do note that Modelish supports both JavaBean models and models
 * that does not have a get/set start but determines what is what
 * depending on argument or no argument. I have however decided to
 * use the JavaBean variant due to that this is written in Groovy
 * which support '.property' access. This makes it more Java Bean
 * compliant. (hmm I can't figure out why I'm constantly thinking
 * of coffee!)
 */
@Human_Software_License_1_0
@SourceAvailableAt("https://github.com/tombensve/")
@BinariesAvailableAt("https://repo.repsy.io/mvn/tombensve/natusoft-os/")

class SGJsonMapConverterProvider implements SGJsonMapConverter {

    /** Static GSon instance. */
    private static  Gson gson = new Gson()

    /** static declaration of Map<String, Object) type. */
    private static Type mapType = new TypeToken<Map<String, Object>>(){}.getType()

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

        gson.toJson( modelMap, mapType) as String
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

        gson.fromJson(json, mapType) as Map<String, Object>
    }
}
