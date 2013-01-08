/**
 * Unit-API - Units of Measurement API for Java (http://unitsofmeasurement.org)
 * Copyright (c) 2005-2011, Unit-API contributors, JScience and others
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package org.unitsofmeasurement.quantity;

import org.unitsofmeasurement.unit.Unit;


/**
 * Quantitative properties or attributes of thing.
 * Mass, time, distance, heat, and angular separation
 * are among the familiar examples of quantitative properties.
 *
 * <p>This interface is used to specify the quantitative property associated to
 * a class through class parameterization and to provide limited compile time
 * dimension consistency.</p>
 *
 * [code]
 * Unit<Mass> pound = ...
 * Quantity<Length> size = ...
 * Sensor<Temperature> thermometer = ...
 * Vector3D<Velocity> aircraftSpeed = ...
 * [/code]
 *
 * @param <Q> The type of the quantity.
 *
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author <a href="mailto:desruisseaux@users.sourceforge.net">Martin Desruisseaux</a>
 * @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @version 1.3
 *
 * @see <a href="http://en.wikipedia.org/wiki/Quantity">Wikipedia: Quantity</a>
 */
public interface Quantity<Q extends Quantity<Q>> {
    /**
     * Returns the value of this quantity as a number stated in this quantity
     * {@linkplain #unit() unit}.
     *
     * @return the value of this quantity (can not be {@code null}).
     */
    Number value();

    /**
     * Returns the unit of this quantity {@linkplain #value() value}.
     *
     * @return the unit of this quantity (can not be {@code null}).
     */
    Unit<Q> unit();
}
