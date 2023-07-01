package se.natusoft.seagull.api

import groovy.transform.CompileStatic
import se.natusoft.docutations.Nullable

/**
 * Generic handler api inspired by Vert.x.
 *
 * @param <T> The type of a potential value to handle.
 */
@CompileStatic
interface SGHandler<T> {

    /**
     * Does the handling.
     *
     * @param value A value to handle.
     */
    void handle( @Nullable T value )
}
