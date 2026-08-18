package se.natusoft.seagull

import groovy.transform.CompileStatic
import se.natusoft.lic.annotation.BinariesAvailableAt
import se.natusoft.lic.annotation.Human_Software_License_1_0
import se.natusoft.lic.annotation.SourceAvailableAt

/**
 * Contains the _Main_ method.
 */
@Human_Software_License_1_0
@SourceAvailableAt("https://github.com/tombensve/Seagull")
@BinariesAvailableAt("https://repo.repsy.io/mvn/tombensve/natusoft-os/")

@CompileStatic
class SGBoot {

    /**
     * Main startup and setup.
     *
     * @param args Parameters in "name=value" format. Can pass as many as you want.
     *             Will be available in passed Properties object.
     */
    static void main( String[] args ) {
        
        for (String property : args) {
            String[] nameValue = property.split( "=" )
            SGStatics.startupProps.setProperty( nameValue[ 0 ], nameValue[ 1 ] )
        }
        
        println "Starting Seagull instance version 1.0.0"
        println SGStatics.startupProps.toString()
        
        // TODO
        
    }

}
