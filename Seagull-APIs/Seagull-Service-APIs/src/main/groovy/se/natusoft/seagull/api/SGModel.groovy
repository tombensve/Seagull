package se.natusoft.seagull.support

import se.natusoft.tools.modelish.Factory

/**
 * Seagull is using a tool from me called Modelish which creates
 * models with generic functionality using interfaces for defining setters and
 * getters. So basically your create an interface extending this interface
 * replacing the <T> with the name of the model interface.
 *
 * Modelish supports both JavaBeans style with getters and setters, but also
 * what I believe is called the "fluent" style that just contains the
 * property name and no get nor set. A setter is one that takes a value and
 * a getter is one that takes no value. Due to Groovy's JavaBean support giving
 * access using only property names that can be used in a more flexible way
 * I have decided to use the standard JavaBean format for models.
 *
 * That said, this is what I will do for the standard models used by
 * Seagull. Models made in a service implementations that Seagull doesn't
 * know anything about can use the shorter "fluent" syntax for the data
 * passed if wanted. Any model not part of the API can be whatever you want,
 * but that said I personally would not mix, but that is purely personal.
 *
 * Also note that when this is created the first time it can set default
 * values, which can be changed in the clone of this.
 *
 * @param <T> The model type.
 */
interface SGModel<T> extends Factory<T> {}
