package se.natusoft.seagull.api.internal

/**
 * This is an internal API that allows for looking up locally available services.
 * This should be called to get an instance in a static "use" constant in APIs
 * that provide a callable singleton instance, which is what should be used to call
 * the actual internal instance.
 *
 * @param <T> The service API.
 */
class SGLocalServiceFinder<T> {

    /**
     * Provides static method for loading a service specified by its interface class.
     * This currently (and most probably always) returns an instance provided by the
     * Java ServiceLoader class.
     *
     * @param api The interface class to get implementation for.
     *
     * @return An implementation of the API.
     */
    static <T> T find( Class<T> api) {

        return (T)ServiceLoader.load( api ).findFirst(  ).get(  )
    }

    /**
     * Provides a static method fore finding all instances of providing implementations of the api.
     *
     * @param api The interface class to get the implementation for.
     *
     * @return All implementations of the API.
     */
    static <T> List<T> findAll( Class<T> api) {

        return ServiceLoader.load( api ).asList(  )
    }
}
