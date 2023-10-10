package se.natusoft.seagull.internal

import groovy.transform.CompileStatic

/**
 * <p>
 *     The Seagull-Platform jar mostly defines interfaces. Other jars has to be added
 *     to the classpath that implements these interfaces. This class is used for looking
 *     up an implementation of a specified interface. Javas ServiceLoader is used for this.
 *     All implementations should be annotated with Googles '@AutoService'.
 * </p>
 */
@CompileStatic
class SGProviderLookup<T> {

    /**
     * Provides static method for loading a service specified by its interface class.
     * This currently (and most probably always) returns an instance provided by the
     * Java ServiceLoader class.
     *
     * @param api The interface class to get implementation for.
     *
     * @return An implementation of the API.
     */
    static <T> T find( Class<T> api ) {

        return (T) ServiceLoader.load( api ).findFirst().get()
    }

    /**
     * Provides a static method fore finding all instances of providing implementations of the api.
     *
     * @param api The interface class to get the implementation for.
     *
     * @return All implementations of the API.
     */
    static <T> List<T> findAll( Class<T> api ) {

        return ServiceLoader.load( api ).asList()
    }
}