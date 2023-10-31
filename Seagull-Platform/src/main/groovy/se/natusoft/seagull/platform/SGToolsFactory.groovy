package se.natusoft.seagull.platform

import se.natusoft.docutations.Singleton
import se.natusoft.seagull.internal.SGProviderLookup
import se.natusoft.seagull.platform.tools.SGID
import se.natusoft.seagull.platform.tools.SGJsonIO

/**
 * Implementations of this provides own implementations of these objects.
 * This so that different implementations can provide own way of handling these.
 *
 * It will find whatever implementation is available runtime.
 */
@Singleton
interface SGToolsFactory {

    static final use = SGProviderLookup<SGToolsFactory>.find(SGToolsFactory.class)

    /**
     * @return a new instance of SGID.
     */
    SGID newSGID()

    /**
     * @return a new instance of SGJsonIO.
     */
    SGJsonIO newSGJsonIO()

}
