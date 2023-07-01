package se.natusoft.seagull.base

import groovy.transform.CompileStatic
import se.natusoft.docutations.Documentative

/**
 * This indicates that the implementation of this service provides service over the network
 * and/or locally, but by service API in that case. Callers of such services does not care
 * where the service is, locally available or remotely over network. It uses the external
 * API even if the service is found locally in deployed binary.
 *
 * Most services are of this type. These always send and receive JSON messages.
 */
@CompileStatic
@Documentative
interface SGNetworkService {}
