/**
 * Unit-API - Units of Measurement API for Java (http://unitsofmeasurement.org)
 * Copyright (c) 2005-2013, Unit-API contributors, JScience and others
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package org.unitsofmeasurement.unit;

import org.unitsofmeasurement.quantity.Quantity;

/**
 * This interface returns a {@link Unit}
 * 
 * @author Werner Keil
 * @version 1.2 ($Revision$), 2013-01-27
 * @param <Q>
 *            The type of the quantity.
 * @see Unit
 * @since 0.7
 */
public interface UnitProvider<Q extends Quantity<Q>> {
	/**
	 * Returns the unit of this UnitProvider {@linkplain #value() value}.
	 * 
	 * @return the unit (can not be {@code null}).
	 */
	Unit<Q> unit();
}
