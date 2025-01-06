package se.natusoft.seagull.type

import org.junit.jupiter.api.Test
import se.natusoft.seagull.SGId
import se.natusoft.seagull.exceptions.SGException

class SFIdTest {

    @Test
    void testSFId() {

        SGId test1 = SGId.register( "se.natusoft", "Seagull" )

        assert test1.toString() == "se.natusoft:Seagull"

        try {
            SGId test2 = SGId.register( "se.natusoft", "Seagull" )

            throw new RuntimeException( "An exceptions should have been thrown, bat wasn't!" )
        }
        catch ( SGException sge ) {
            println "Expected: Registration failed! -> ${sge.toString()}"
            println "This is expected!"
        }
    }
}
