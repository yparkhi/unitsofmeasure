/**
 * Unit-API - Units of Measurement API for Java (http://unitsofmeasurement.org)
 * Copyright (c) 2005-2012, Unit-API contributors, JScience and others
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package org.unitsofmeasurement.quantity;

import org.unitsofmeasurement.unit.Unit;

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
 * [code] Unit<Mass> pound = ... NumericQuantity<Length> size = ...
 * Sensor<Temperature> thermometer = ... Vector3D<Velocity> aircraftSpeed = ...
 * [/code]
 * </p>
 * 
 * @param <Q>
 *            The type of the NumericQuantity.
 * 
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author <a href="mailto:desruisseaux@users.sourceforge.net">Martin
 *         Desruisseaux</a>
 * @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @see <a href="http://en.wikipedia.org/wiki/NumericQuantity">Wikipedia:
 *      NumericQuantity</a>
 * @version 1.5 ($Revision$), $Date: 2012-04-30 01:36:47 +0200 (Mo, 30 Apr
 *          2012) $
 * @deprecated data type should be implementation specific, thus at API level
 *             Generics preferred.
 */
public interface NumericQuantity<Q extends Quantity<Q, Number>> extends
		Quantity<Q, Number> {

    /**
     * Returns the unit of this NumericQuantity {@linkplain #value() value}.
     *
     * @return the unit of this NumericQuantity (can not be {@code null}).
     */
	Unit<Q, Number> unit();
}
