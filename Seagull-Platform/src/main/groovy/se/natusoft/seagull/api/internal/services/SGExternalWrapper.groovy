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
 * This should be extended to provide an internal API for wrapping
 * functionality in external libraries.
 *
 * ALL external code should be wrapped like this! Googles @AutoService is
 * used to find implementation providers.
 *
 * The reasons for this are:
 *   Internal code should have no knowledge of specific external library
 *   APIs! Interfaces are created for the needed functionality. Then an
 *   implementation is provided providing functionality from an external
 *   library. The internal code have no dependency to the external
 *   library, only to wrapper APIs to access functionality. This also
 *   means that internal code does not have any direct dependency to
 *   external libraries, but only to the internal wrapper APIs. Thus
 *   all external libraries will be treated as just external
 *   functionality providers that internal code does not need to know
 *   specifics of. Functionality providers can easily be replaced
 *   without affecting internal code.
 *
 *   This will also make it extremely clear just what is used from
 *   an external library!
 *
 *   Let your external library wrappers extend this to make it clear
 *   what it is.
 */
abstract interface SGExternalWrapper {}
