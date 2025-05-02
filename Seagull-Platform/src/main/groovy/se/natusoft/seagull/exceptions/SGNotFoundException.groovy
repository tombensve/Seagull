package se.natusoft.seagull.exceptions

import groovy.transform.CompileStatic
import se.natusoft.lic.annotation.BinariesAvailableAt
import se.natusoft.lic.annotation.Human_Software_License_1_0
import se.natusoft.lic.annotation.SourceAvailableAt

@Human_Software_License_1_0
@SourceAvailableAt("https://github.com/tombensve/")
@BinariesAvailableAt("https://repo.repsy.io/mvn/tombensve/natusoft-os/")

/**
 * A General Not found exception.
 */
@CompileStatic
class SGNotFoundException extends SGException {

    SGNotFoundException(
            String message = "(No message!)", Throwable cause = new RuntimeException("(Unknown cause!)")
    ) {
        super(message, cause)
    }
}
