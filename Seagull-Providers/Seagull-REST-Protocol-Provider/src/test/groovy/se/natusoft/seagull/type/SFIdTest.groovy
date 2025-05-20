package se.natusoft.seagull.type

import groovy.transform.CompileStatic
import org.junit.jupiter.api.Test
import se.natusoft.seagull.SGID
import se.natusoft.seagull.exceptions.SGException

@CompileStatic
class SFIdTest {

    @Test
    void testSFId() {

        SGID test1 = SGID.register( "test", "se.natusoft", "Seagull" )

        assert test1.toString() == "test:se.natusoft:Seagull"

        try {
            SGID test2 = SGID.register( "test", "se.natusoft", "Seagull" )

            throw new RuntimeException( "An exceptions should have been thrown, bat wasn't!" )
        }
        catch ( SGException sge ) {
            println "Expected: Registration failed! -> ${sge.toString()}"
            println "This is expected!"
        }
    }
}
