package se.natusoft.seagull.platform.tools

import groovy.transform.CompileStatic


//TODO Make into interface and implementation
/**
 * This might be a  bit of overkill, but allows for changing the ID implementation.
 */
@CompileStatic
class SGIdProvider {

    private UUID id

    SGIdProvider() {
        id = UUID.randomUUID()
    }

    /**
     * @return the ID as a string.
     */
    String toString() {
        id.toString()
    }

    /**
     * Compare for equality.
     *
     * @param toCompare The object to compare with.
     *
     * @return true or false.
     */
    boolean equals(SGIdProvider toCompare) {
        return toCompare.id == this.id
    }
}
