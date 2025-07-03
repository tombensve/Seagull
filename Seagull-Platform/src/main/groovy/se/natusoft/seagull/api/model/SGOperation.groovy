package se.natusoft.seagull.api.model

import groovy.transform.CompileStatic
import se.natusoft.lic.annotation.BinariesAvailableAt
import se.natusoft.lic.annotation.Human_Software_License_1_0
import se.natusoft.lic.annotation.SourceAvailableAt

@Human_Software_License_1_0
@SourceAvailableAt("https://github.com/tombensve/")
@BinariesAvailableAt("https://repo.repsy.io/mvn/tombensve/natusoft-os/")

/**
 * Standard CRUD operations.
 */
@CompileStatic
enum SGOperation {

    CREATE,

    READ,

    UPDATE,

    DELETE,
    
    AUTO_RESOLVED,
    
    IRRELEVANT
}
