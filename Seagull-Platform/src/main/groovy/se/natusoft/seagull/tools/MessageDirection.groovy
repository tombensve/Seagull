package se.natusoft.seagull.tools

import se.natusoft.lic.annotation.BinariesAvailableAt
import se.natusoft.lic.annotation.Human_Software_License_1_0
import se.natusoft.lic.annotation.SourceAvailableAt

@Human_Software_License_1_0
@SourceAvailableAt("https://github.com/tombensve/Seagull")
@BinariesAvailableAt("https://repo.repsy.io/mvn/tombensve/natusoft-os/")

/**
 * Use these as follows: MessageDirection.REQ.toString()
 *
 * This is just a convenience, "REQ" and "RES" also works.
 */
enum MessageDirection {
    REQ, // Request
    RES  // Response.
}
