package se.natusoft.seagull.exceptions

import groovy.transform.CompileStatic
import org.junit.jupiter.api.Test
import se.natusoft.lic.annotation.Apache_Software_License_2_0

@CompileStatic

@Apache_Software_License_2_0
class TestExceptions {

    /**
     * Just validating that Groovy handles default value for argument.
     */
    @Test
    void testArgs() throws SGException {

        SGException se1 = new SGException( "test", new RuntimeException("Test-1"))

        assert se1.cause.toString() == "java.lang.RuntimeException: Test-1"

        SGException se2 = new SGException("test-3")

        assert se2.cause.toString() == "java.lang.RuntimeException: [Unknown cause!]"
    }
}
