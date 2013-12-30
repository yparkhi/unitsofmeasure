/**
 * Unit-API - Units of Measurement API for Java (http://unitsofmeasurement.org)
 * Copyright (c) 2005-2014, Unit-API contributors and others
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package javax.measure;

import javax.measure.function.MeasurementConverter;
import javax.measure.function.UnitSupplier;
import javax.measure.function.ValueSupplier;

/**
 * Represents a value with a unit.
 * 
 * A Measurement object is used for maintaining the tuple of value and unit.
 * </br> Arithmetic methods are provided. At least a runtime error (for some
 * operations already at compile time) will occur when two measurements are used
 * in an incompatible way. E.g., when a speed (m/s) is added to a distance (m).
 * The measurement class will correctly track changes in unit during
 * multiplication and division, always coercing the result to the most simple
 * form. See <type>Unit</type> for more information on the supported units.
 * 
 * <p>
 * Measurement instances should be immutable.
 * </p>
 * 
 * @param <Q>
 *            The type of the quantity measured.
 * @param <V>
 *            The value of the quantity measured.
 * 
 * @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @see <a href="http://en.wikipedia.org/wiki/Units_of_measurement"> Wikipedia:
 *      Units of measurement</a>
 * @version 1.10 ($Revision$), $Date$
 */
public interface Measurement<Q extends Quantity<Q>, V> extends UnitSupplier<Q>,
	ValueSupplier<V>, MeasurementConverter<Q, V> {

	/**
	 * Returns the value of this measurement as a V.
	 * 
	 * @return the value of this measurement (can not be {@code null}).
	 */
	// TODO why shouldn't it be null? 
	// TODO If we used compatible signature with Java 8 Supplier it would extend Supplier<V> as V get()
	V getValue();

	/**
	 * Returns the sum of this amount with the one specified.
	 * 
	 * @param that
	 *            the amount to be added.
	 * @return <code>this + that</code>.
	 */
	Measurement<Q, V> add(Measurement<Q, V> that);

	/**
	 * Returns the difference between this amount and the one specified.
	 * 
	 * @param that
	 *            the number to be subtracted.
	 * @return <code>this - that</code>.
	 */
	Measurement<Q, V> substract(Measurement<Q, V> that);

	/**
	 * Returns the product of this amount with the one specified.
	 * 
	 * @param that
	 *            the amount multiplier.
	 * @return <code>this · that</code>.
	 */
	Measurement<?, V> multiply(Measurement<?, V> that);

	/**
	 * Returns the product of this amount with the number specified.
	 * 
	 * @param that
	 *            the number multiplier.
	 * @return <code>this · that</code>.
	 */
	Measurement<?, V> multiply(V that);

	/**
	 * Returns this amount divided by the one specified.
	 * 
	 * @param that
	 *            the amount divisor.
	 * @return <code>this / that</code>.
	 */
	Measurement<?, V> divide(Measurement<?, V> that);

	Measurement<Q, V> inverse();
}
