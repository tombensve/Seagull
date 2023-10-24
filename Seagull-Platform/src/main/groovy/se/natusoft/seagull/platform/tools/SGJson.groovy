package se.natusoft.seagull.platform.tools

import groovy.transform.CompileStatic

/**
 * This is a simple container for Seagull JSON data to simplify APIs a bit.
 *
 * Having an instance of this holding the JSON tree of Map<String, Object> makes it cleaner
 * in general to deal with this type, and in future easier to change how this type is handled.
 */
@CompileStatic
class SGJson extends LinkedHashMap<String, Object> {}
