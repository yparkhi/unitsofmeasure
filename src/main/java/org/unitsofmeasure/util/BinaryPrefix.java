/**
 * The Units of Measure API, UCUM codes, UCUM table (regardless of format),
 * and UCUM Specification are copyright © 1999-2010,
 * Regenstrief Institute, Inc. and the Unified Codes for Units of Measures
 * (UCUM) Organization. All rights reserved.
 *
 * See TermsOfUse for details.
 */
package org.unitsofmeasure.util;

import org.unitsofmeasure.Quantity;
import org.unitsofmeasure.Unit;

/**
 * <p>
 * This class provides support for common binary prefixes to be used by units.
 * </p>
 * <p>
 * This class is not intended to be implemented by clients.
 * </p>
 * @noextend This class is not intended to be extended by clients.
 * 
 * @author <a href="mailto:jcp@catmedia.us">Werner Keil</a>
 * @version 1.2 ($Revision: 53 $), $Date: 2010-08-17 00:24:40 +0200 (Di, 17 Aug 2010) $
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
	public static final <Q extends Quantity<Q>> Unit<?> KIBI(Unit<?> unit) {
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
	public static final <Q extends Quantity<Q>> Unit<?> MEBI(Unit<?> unit) {
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
	public static final <Q extends Quantity<Q>> Unit<?> GIBI(Unit<?> unit) {
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
	public static final <Q extends Quantity<Q>> Unit<?> TEBI(Unit<?> unit) {
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
	public static final <Q extends Quantity<Q>> Unit<?> PEBI(Unit<?> unit) {
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
	public static final <Q extends Quantity<Q>> Unit<?> EXBI(Unit<?> unit) {
		return unit.multiply(1152921504606846976L);
	}
}
