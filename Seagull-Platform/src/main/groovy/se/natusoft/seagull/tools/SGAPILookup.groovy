package se.natusoft.seagull.tools

import groovy.transform.CompileStatic
import se.natusoft.lic.annotation.BinariesAvailableAt
import se.natusoft.lic.annotation.Human_Software_License_1_0
import se.natusoft.lic.annotation.SourceAvailableAt

@Human_Software_License_1_0
@SourceAvailableAt("https://github.com/tombensve/")
@BinariesAvailableAt("https://repo.repsy.io/mvn/tombensve/natusoft-os/")

/**
 * The Seagull-Platform jar mostly defines interfaces. Other jars has to be added
 * to the classpath that implements these interfaces. This class is used for getting
 * an implementation of a specified interface.
 *
 * I'm not using ServiceLoader generally in code, but wrapping it here to have
 * more flexibility in how this is handled. My goal is actually to encapsulate
 * all external code which I have no control over!
 *
 * Since I have not succeeded in making Googles @AutoService work, the resources
 * needed to make these available have to be provided manually as resources.
 * And YES, this annoys the hell out of me!
 */
@CompileStatic
class SGAPILookup {

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
