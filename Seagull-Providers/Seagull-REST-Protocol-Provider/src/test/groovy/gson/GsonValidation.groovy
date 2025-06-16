package gson

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.junit.jupiter.api.Test
import se.natusoft.tools.modelish.Modelish

import java.lang.reflect.Type

class GsonValidation {

    /**
     * This starts with a String of JSON and then parses it by Gson. Gson produces
     * a Map<String, Object>. Then we take this Map and pass as data to a Modelish model
     * that has the same bean properties as the result of the JSON parsing, and use
     * that Map to Modelish when creating a model instance to use as data content.
     * The asserts verify that the modelish model uses the Map data without problems.
     */
    @Test
    void simpleTest() {

        String jsonString = '{"name":"test","decimal":9.711,"bool":true}'

        println jsonString

        // Use Googles Gson.
        Gson gson = new Gson()
        Type type = new TypeToken<Map<String, Object>>(){}.getType()

        Map<String, Object> map = gson.fromJson(jsonString, type)

        println(map)

        // Note that this is a map!
        assert map.name == "test"

        // TestModel is just an interface with property setters and getters.
        TestModel testModel = Modelish.createFromMap( TestModel.class as Class<TestModel>, map) as TestModel

        // Note that TestModel is an interface!
        assert testModel.name == "test"

        assert testModel.decimal == 9.711d // Using the 'd' suffix for double works best!

        assert testModel.bool
    }
}
