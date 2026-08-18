package se.natusoft.seagull.provider.internal

import org.junit.jupiter.api.Test
import se.natusoft.seagull.api.SGJsonMapConverter
import se.natusoft.seagull.tools.SGProviderLookup

/**
 * This test takes a JSON string, converts it to a Map structure,
 * and then takes the Map structure and converts back to String.
 *
 * This test does the following:
 * - Creates a String of JSON.
 * - Converts the JSON to a Map<String, Object> structure.
 * - Then takes the Map and converts to JSON.
 *
 * Googles eminent GSon tool is used under the surface to provide
 * these conversions. The Map structure is used as input to
 * a Modelish model that wraps the Map as data for a modelish
 * JavaBean provided by only using interfaces. Modelish also
 * support immutability and cloning. Seagull uses Modelish
 * models.
 */
// PROBLEM ==> GSON converts integers to decimals!!!
class SGJsonMapConverterTest {
    
    static final SGJsonMapConverter sgJsonMapConverter =
            SGProviderLookup.find( SGJsonMapConverter.class )
    
    @Test
    void testJSONMapConverterLookup() {
        
        assert sgJsonMapConverter != null
    }
    
    @Test
    void testJSON2Map() {
        
        String json = """  
           { 
              "firstName": "Tommy", 
              "lastName": "Svensson",
              "age": 58,
              "demented": true
           } 
        """
        
        Map<String, Object> map = sgJsonMapConverter.toMap( json )
        
        assert map.firstName == "Tommy"
        assert map.lastName == "Svensson"
        assert map.age as int == 58 // GSon makes this a decimal!
        assert map.demented == true
        
        // Now we take this Map and turn it to JSON again!
        
        String jsonString = sgJsonMapConverter.toJSON( map )
        
        assert jsonString == "{\"firstName\":\"Tommy\",\"lastName\":\"Svensson\"," +
                "\"age\":58.0,\"demented\":true}"
        //println jsonString
    }
}
