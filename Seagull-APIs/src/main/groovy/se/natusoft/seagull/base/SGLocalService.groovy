package se.natusoft.seagull.base

import groovy.transform.CompileStatic
import se.natusoft.docutations.Documentative

/**
 * This indicates that the implementation of this service need to be looked up using
 * SGLocalServiceFinder.
 *
 * This provides internal/local functionality that is part of the "platform".
 */
@CompileStatic
@Documentative
interface SGLocalService {}
