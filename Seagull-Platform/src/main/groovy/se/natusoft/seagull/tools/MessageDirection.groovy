package se.natusoft.seagull.tools

import se.natusoft.lic.annotation.BinariesAvailableAt
import se.natusoft.lic.annotation.Human_Software_License_1_0
import se.natusoft.lic.annotation.SourceAvailableAt

@Human_Software_License_1_0
@SourceAvailableAt("https://github.com/tombensve/Seagull")
@BinariesAvailableAt("https://repo.repsy.io/mvn/tombensve/natusoft-os/")

/**
 * Use these as follows:
 *
 *     MessageDirection.REQUEST
 *     MessageDirection.RESPONSE
 *
 */
interface MessageDirection {
    
    public static final String REQUEST = "->"
    public static final String RESPONSE = "<-"
    
}
