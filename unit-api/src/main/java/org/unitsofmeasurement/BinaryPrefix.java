/**
 * Unit-API - Units of Measurement API for Java (http://unitsofmeasurement.org)
 * Copyright (c) 2005-2010, Unit-API contributors, JScience and others
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package org.unitsofmeasurement;

import org.unitsofmeasurement.quantity.Quantity;

/**
 * <p>
 * This class provides support for common binary prefixes to be used by units.
 * </p>
 * <p>
 * This class is not intended to be implemented by clients.
 * </p>
 * @noextend This class is not intended to be extended by clients.
 * 
 * @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @version 1.2.1 ($Revision$), $Date$
 */
public final class BinaryPrefix {

	private BinaryPrefix() {
		// Utility class no visible constructor.
	}

	/**
	 * Returns the specified unit multiplied by the factor
	 * <code>2<sup>10</sup></code> (binary prefix).
	 * 
	 * @param unit
	 *            any unit.
	 * @return <code>unit.times(1024)</code>.
	 */
	public static <Q extends Quantity<Q>> Unit<?> KIBI(Unit<?> unit) {
		return unit.multiply(1024);
	}

	/**
	 * Returns the specified unit multiplied by the factor
	 * <code>2<sup>20</sup></code> (binary prefix).
	 * 
	 * @param unit
	 *            any unit.
	 * @return <code>unit.times(1048576)</code>.
	 */
	public static <Q extends Quantity<Q>> Unit<?> MEBI(Unit<?> unit) {
		return unit.multiply(1048576);
	}

	/**
	 * Returns the specified unit multiplied by the factor
	 * <code>2<sup>30</sup></code> (binary prefix).
	 * 
	 * @param unit
	 *            any unit.
	 * @return <code>unit.times(1073741824)</code>.
	 */
	public static <Q extends Quantity<Q>> Unit<?> GIBI(Unit<?> unit) {
		return unit.multiply(1073741824);
	}

	/**
	 * Returns the specified unit multiplied by the factor
	 * <code>2<sup>40</sup></code> (binary prefix).
	 * 
	 * @param unit
	 *            any unit.
	 * @return <code>unit.times(1099511627776L)</code>.
	 */
	public static <Q extends Quantity<Q>> Unit<?> TEBI(Unit<?> unit) {
		return unit.multiply(1099511627776L);
	}

	/**
	 * Returns the specified unit multiplied by the factor
	 * <code>2<sup>50</sup></code> (binary prefix).
	 * 
	 * @param unit
	 *            any unit.
	 * @return <code>unit.times(1125899906842624L)</code>.
	 */
	public static <Q extends Quantity<Q>> Unit<?> PEBI(Unit<?> unit) {
		return unit.multiply(1125899906842624L);
	}

	/**
	 * Returns the specified unit multiplied by the factor
	 * <code>2<sup>60</sup></code> (binary prefix).
	 * 
	 * @param unit
	 *            any unit.
	 * @return <code>unit.times(1152921504606846976L)</code>.
	 */
	public static <Q extends Quantity<Q>> Unit<?> EXBI(Unit<?> unit) {
		return unit.multiply(1152921504606846976L);
	}
}
