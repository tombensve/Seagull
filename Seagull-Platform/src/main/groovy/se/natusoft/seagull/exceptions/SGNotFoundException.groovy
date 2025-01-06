package se.natusoft.seagull.exceptions

import groovy.transform.CompileStatic
import se.natusoft.lic.annotation.Apache_Software_License_2_0

/**
 * A General Not found exception.
 */
@Apache_Software_License_2_0
@CompileStatic
class SGNotFoundException extends SGException {

    SGNotFoundException(
            String message = "(No message!)", Throwable cause = new RuntimeException("(Unknown cause!)")
    ) {
        super(message, cause)
    }
}
