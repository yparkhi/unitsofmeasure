/**
 * Copyright (c) 2013 Werner Keil and others.
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package javax.measure.function;

import javax.measure.Quantity;
import javax.measure.Unit;

/**
 * This interface transforms a {@link Unit}
 * 
 * @author Werner Keil
 * @version 0.2 ($Revision: 237 $), 2013-01-27
 * @param <Q>
 *            The type of the quantity.
 * @see Unit
 */
//@FunctionalInterface
public interface UnitTransformer<Q extends Quantity<Q>> {
	/**
	 * Returns the unit of this UnitProvider {@linkplain #getValue() value}.
	 * 
	 * @return the unit (can not be {@code null}).
	 */
	Unit<Q> transform(UnitConverter converter);
}
