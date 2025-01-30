package se.natusoft.seagull.api

import se.natusoft.seagull.tools.SGAPIProvider

/**
 * Seagull logger. Implementations can use any logging library wanted or handle it directly
 * without any library. This is just the API used to log by Seagull code in general.
 *
 * ALWAYS USE: SGLogger.instance when logging!!!!
 *
 * EVERY THING ELSE HERE IOS PRIVATE!
 */
interface SGLogger {

    /**
     * Provides a static instance of SGLogger by looking up a provided implementation.
     * This will always be available one way or another!
     *
     * DO NOTE that there can only be 0 or 1 SGLogger implementation available in a Jar file!
     * If 0 a very simple STDOUT logger will be provided! It is strongly recommended to
     * provide an SGLogger implementation!!
     */
    static final SGLogger instance = LoggerFinder.lookup()

    void log( String message )

    void log( Throwable throwable )

    void log( String message, Throwable throwable )
}

////////////////////////////////////////////////////////////////////////////////////////////
// Below are code to make sure that there will always be a logger provided, a very simple //
// default one if no other is provided.                                                   //
///////////////////////////////////////////////////////////////////////////////////////////

/**
 * This will find a logger implementation provided via ServiceLoader, and if not
 * it will return the default logger.
 */
class LoggerFinder {

    static SGLogger lookup() {
        SGLogger instance = SGAPIProvider.find( SGLogger.class )
        if ( instance == null ) {
            System.err.println "NO LOGGER PROVIDED! Primitive default will be used!"
            System.err.println "Yes, this message is here to annoy you!"
            instance = new SGDefaultLogger()
        }

        instance
    }
}

/**
 * This logs to stdout in simplest way possible! It is used only if no other SGLogger
 * implementation is provided.
 */
class SGDefaultLogger implements SGLogger {

    void log( String message ) {
        println message
    }

    void log( Throwable throwable ) {
        println throwable.toString()
    }

    void log( String message, Throwable throwable ) {
        println message
        println throwable.toString()
    }
}
