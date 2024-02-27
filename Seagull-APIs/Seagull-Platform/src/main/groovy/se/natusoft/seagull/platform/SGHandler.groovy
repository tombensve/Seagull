package se.natusoft.seagull.platform

import groovyjarjarantlr4.v4.runtime.misc.Nullable

/**
 * This provides a value when such is available.
 *
 * In Groovy this can be implemented using a closure!! I'm defining it as an interface
 * like this to make it compatible with Java.
 *
 * @param <T> The type of the value.
 */
interface SGHandler<T> {
    /**
     * Does the handling.
     *
     * @param value A value to handle.
     */
    void handle( @Nullable T value )
}
