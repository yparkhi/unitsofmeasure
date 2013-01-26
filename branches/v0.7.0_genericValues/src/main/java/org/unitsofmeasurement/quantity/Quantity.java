/**
 * Unit-API - Units of Measurement API for Java (http://unitsofmeasurement.org)
 * Copyright (c) 2005-2013, Unit-API contributors, JScience and others
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package org.unitsofmeasurement.quantity;

import org.unitsofmeasurement.Measurement;

/**
 * <p>
 * Represents a quantitative properties or attributes of thing. Mass, time,
 * distance, heat, and angular separation are among the familiar examples of
 * quantitative properties.
 * </p>
 * 
 * <p>
 * This interface is used to specify the quantitative property associated to a
 * class through class parameterization and to provide limited compile time
 * dimension consistency.
 * 
 * [code] Unit<Mass> pound = ... Quantity<Length> size = ... Sensor<Temperature>
 * thermometer = ... Vector3D<Velocity> aircraftSpeed = ... [/code]
 * </p>
 * 
 * @param <Q>
 *            The type of the quantity.
 * 
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author <a href="mailto:desruisseaux@users.sourceforge.net">Martin
 *         Desruisseaux</a>
 * @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @see <a href="http://en.wikipedia.org/wiki/Quantity">Wikipedia: Quantity</a>
 * @version 1.7 ($Revision$), Date: 2013-01-26
 */
public interface Quantity<Q extends Quantity<Q>> extends Measurement<Q, Number> {
}
