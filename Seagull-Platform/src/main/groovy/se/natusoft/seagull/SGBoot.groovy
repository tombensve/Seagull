package se.natusoft.seagull

import groovy.transform.CompileStatic
import se.natusoft.lic.annotation.Apache_Software_License_2_0
import se.natusoft.lic.annotation.BinariesAvailableAt
import se.natusoft.lic.annotation.SourceAvailableAt

/**
 * Contains the _Main_ method.
 */
@Apache_Software_License_2_0
@BinariesAvailableAt("https://repo.repsy.io/mvn/tombensve/natusoft-os/")
@SourceAvailableAt("https://github.com/tombensve/")

@CompileStatic
class SGBoot {

    /**
     * Main startup and setup.
     *
     * @param args Parameters in "name=value" format. Can pass as many as you want.
     *             Will be available in passed Properties object.
     */
    static void main( String[] args ) {

        args.each { String props ->

            String[] nameValue = props.split( "=" )
            SGStatics.startupProps.setProperty( nameValue[ 0 ], nameValue[ 1 ] )
        }

        println "Starting Seagull instance version 1.0.0"
        println "Provided properties:"
        println SGStatics.startupProps.toString()

        // Load Protocols //

        /*
        SGAPIProvider.findAll( SGProtocol.class )
                .each { SGProtocol protocol ->
                    SGStatics.protocols.put( protocol.protocolName(), protocol )
                    println "Loaded Protocol: ${protocol.protocolName(  )}"
                }

        // ...

         */

    }

}
