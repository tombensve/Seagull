package se.natusoft.seagull

import se.natusoft.lic.annotation.BinariesAvailableAt
import se.natusoft.lic.annotation.Human_Software_License_1_0
import se.natusoft.lic.annotation.SourceAvailableAt

@Human_Software_License_1_0
@SourceAvailableAt("https://github.com/tombensve/")
@BinariesAvailableAt("https://repo.repsy.io/mvn/tombensve/natusoft-os/")

 /**
 * Holds static data provided at startup.
 */
interface SGStatics {

    /** These properties are accessible from anywhere in the code. */
    static final Properties startupProps = new Properties()

}
