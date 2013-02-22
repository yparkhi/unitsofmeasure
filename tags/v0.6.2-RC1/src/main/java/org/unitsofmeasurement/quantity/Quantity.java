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
 * <cite>Property of a phenomenon, body, or substance, where the property has a magnitude
 * that can be expressed as a number and a unit</cite> <font size="-2">(adapted from
 * <a href="http://www.bipm.org/utils/common/documents/jcgm/JCGM_200_2012.pdf">VIM</a>)</font>.
 * Mass, time, distance, heat, and angular separation are among the familiar examples
 * of quantitative properties.
 *
 * <p><cite>Kind of quantity</cite>, represented by sub-types, are <cite>aspect common
 * to mutually comparable quantities</cite> (<font size="-2">source: VIM</font>).
 * Sub-types are used to specify the quantitative property associated to
 * a class through class parameterization and to provide limited compile time
 * dimension consistency.</p>
 *
 * [code]
 * Unit<Mass> pound = ...
 * Quantity<Length> size = ...
 * Sensor<Temperature> thermometer = ...
 * Vector3D<Speed> aircraftVelocity = ...
 * [/code]
 *
 * @param <Q> The type of the quantity.
 *
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author <a href="mailto:desruisseaux@users.sourceforge.net">Martin Desruisseaux</a>
 * @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @version 1.3
 *
 * @see <a href="http://en.wikipedia.org/wiki/Physical_quantity">Wikipedia: Physical Quantity</a>
 * @see <a href="http://www.bipm.org/utils/common/documents/jcgm/JCGM_200_2012.pdf">International Vocabulary of Metrology (VIM)</a>
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
