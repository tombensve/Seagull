package se.natusoft.seagull.platform.tools

import groovy.transform.CompileStatic

/**
 * This might be a  bit of overkill, but allows for changing the ID implementation.
 */
@CompileStatic
interface SGID {

    /**
     * @return the ID as a string.
     */
    String toString()

    /**
     * Compare for equality.
     *
     * @param toCompare The object to compare with.
     *
     * @return true or false.
     */
    boolean equals(SGID toCompare)
}
