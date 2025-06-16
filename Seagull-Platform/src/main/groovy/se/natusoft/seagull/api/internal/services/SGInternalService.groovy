package se.natusoft.seagull.api.internal.services

import se.natusoft.lic.annotation.BinariesAvailableAt
import se.natusoft.lic.annotation.Human_Software_License_1_0
import se.natusoft.lic.annotation.SourceAvailableAt

@Human_Software_License_1_0
@SourceAvailableAt("https://github.com/tombensve/")
@BinariesAvailableAt("https://repo.repsy.io/mvn/tombensve/natusoft-os/")

/**
 * This is a marker interface containing absolutely nothing!
 *
 * This should be extended to provide an API for calling functionality
 * in external libraries. This specific interface is just a marker that
 * this is an internal service using code from an external library, which
 * is not exposed generally to internal code.
 *
 * ALL external code should we wrapped like this! Googles @AutoService is
 * used
 */
abstract interface SGInternalService {}
