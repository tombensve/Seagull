package se.natusoft.seagull.platform

/**
 * This might be a  bit of overkill, but allows for changing the ID implementation.
 */
class SGId {

    private String id

    SGId() {
        id = UUID.randomUUID().toString()
    }

    /**
     * @return the ID as a string.
     */
    String toString() {
        id
    }
}
