package se.natusoft.seagull.api

import groovy.transform.CompileStatic
import se.natusoft.lic.annotation.BinariesAvailableAt
import se.natusoft.lic.annotation.Human_Software_License_1_0
import se.natusoft.lic.annotation.SourceAvailableAt
import se.natusoft.seagull.tools.SGProviderLookup

// If the above import is red marked, then you are using IDEA!!!
// There is nothing that can be done about this, other than complain to
// JetBrains, but they do not seem to care.
// This is not a fault in the code, it is a fault in IDEA!!!
// I've gotten tired reporting such things to them. They have proven
// such actions pointless, so I stopped trying many years ago.
//
// Sometimes removing all IDEA related files from project root and
// down, and restart idea helps.

@Human_Software_License_1_0
@SourceAvailableAt( "https://github.com/tombensve/Seagull" )
@BinariesAvailableAt( "https://repo.repsy.io/mvn/tombensve/natusoft-os/" )

/**
 * Seagull logger. Implementations can use any logging library wanted or handle it directly
 * without any library. This is just the API used to log by Seagull code in general.
 *
 * ALWAYS USE: SGLogger.instance when logging!!!!
 * EVERY THING ELSE HERE IS PRIVATE!
 */
@CompileStatic
interface SGLogger {
    
    /**
     * Provides a static instance of SGLogger by looking up a provided implementation.
     * This will always be available one way or another!
     *
     * DO NOTE that there can only be 0 or 1 SGLogger implementation available in a Jar file!
     * If 0 a very simple STDOUT logger will be provided! It is strongly recommended to
     * provide an SGLogger implementation!!
     */
    static final SGLogger instance = LoggerFinder.lookup( )
    
    void log( String message )
    
    void log( Throwable throwable )
    
    void log( String message, Throwable throwable )
}

//.....................................................................................

// Below are code to make sure that there will always be a logger provided, a very simple //
// default one if no other is provided.                                                   //

/**
 * This will find a logger implementation provided via ServiceLoader, and if not
 * it will return the default logger.
 */
@CompileStatic
class LoggerFinder {
    
    private static SGLogger logger = null
    
    protected static SGLogger lookup() {
        
        if ( logger == null ) {
            logger = SGProviderLookup.find( SGLogger.class )
            if ( logger == null ) {
                System.err.println "NO LOGGER PROVIDED! Primitive default will be used!"
                logger = new SGDefaultLogger( )
            }
        }
        
        logger
    }
}

//.....................................................................................

/**
 * This logs to stdout in simplest way possible! It is used only if no other SGLogger
 * implementation is provided.
 */
@CompileStatic
class SGDefaultLogger implements SGLogger {
    
    void log( String message ) {
        println message
        println( )
    }
    
    void log( Throwable throwable ) {
        println throwable.toString( )
        println( )
    }
    
    void log( String message, Throwable throwable ) {
        println message
        println throwable.toString( )
        println( )
    }
}
