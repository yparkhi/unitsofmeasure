/**
 * 
 */
package org.unitsofmeasurement.unit;

import org.unitsofmeasurement.quantity.Quantity;

/**
 * @author Werner
 *
 */
public interface UnitProvider<Q extends Quantity<Q>> {
	/**
	 * Returns the unit of this quantity {@linkplain #value() value}.
	 * 
	 * @return the unit of this quantity (can not be {@code null}).
	 */
	Unit<Q> unit();
}
