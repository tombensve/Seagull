package se.natusoft.seagull.type

import groovy.transform.CompileStatic
import org.junit.jupiter.api.Test
import se.natusoft.seagull.SG_ID
import se.natusoft.seagull.exceptions.SGException

@CompileStatic
class SFIdTest {

    @Test
    void testSFId() {

        SG_ID test1 = SG_ID.register( "test", "se.natusoft", "Seagull" )

        assert test1.toString() == "test:se.natusoft:Seagull"

        try {
            SG_ID test2 = SG_ID.register( "test", "se.natusoft", "Seagull" )

            throw new RuntimeException( "An exceptions should have been thrown, bat wasn't!" )
        }
        catch ( SGException sge ) {
            println "Expected: Registration failed! -> ${sge.toString()}"
            println "This is expected!"
        }
    }
}
