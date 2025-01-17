package se.natusoft.seagull.tools

import groovy.transform.CompileStatic
import se.natusoft.lic.annotation.Apache_Software_License_2_0

/**
 * The Seagull-Platform jar mostly defines interfaces. Other jars has to be added
 * to the classpath that implements these interfaces. This class is used for getting
 * an implementation of a specified interface.
 *
 * The easiest solution is to use Googles @AutoService annotation on implementations.
 * Nothing is however stopping from providing the config resources needed to lookup
 * these manually! But using @AutoService is soo much easier!
 */
@Apache_Software_License_2_0
@CompileStatic
class SGAPIProvider {

    /**
     * Provides static method for loading a service specified by its interface class.
     * This returns an instance provided by the Java ServiceLoader.
     *
     * @param api The interface class to get implementation for.
     *
     * @return An implementation of the API.
     */
    static <T> T find( Class<T> api ) {

        (T) ServiceLoader.load( api ).findFirst().get()
    }

    /**
     * Provides a static method fore finding all instances of providing implementations of the api.
     *
     * @param api The interface class to get the implementation for.
     *
     * @return All implementations of the API.
     */
    static <T> List<T> findAll( Class<T> api ) {

        (List<T>) ServiceLoader.load( api ).asList()
    }
}
