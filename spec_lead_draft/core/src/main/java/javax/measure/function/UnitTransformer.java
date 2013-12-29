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
 * <p>This is a <a href="http://download.java.net/jdk8/docs/api/java/util/function/package-summary.html">functional interface</a>
 * whose functional method is {@link #transform()}.
 * 
 * @author Werner Keil
 * @version 0.3 ($Revision: 237 $), 2013-12-29
 * @param <Q>
 *            The type of the quantity.
 * @see Unit
 */
//equivalent to @FunctionalInterface
public interface UnitTransformer<Q extends Quantity<Q>> {
	/**
	 * Returns the unit of this UnitProvider {@linkplain #getValue() value}.
	 * 
	 * @return the unit (can not be {@code null}).
	 */
	Unit<Q> transform(UnitConverter converter);
}
