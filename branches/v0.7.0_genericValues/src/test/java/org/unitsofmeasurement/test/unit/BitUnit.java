/**
 * Unit-API - Units of Measurement API for Java (http://unitsofmeasurement.org)
 * Copyright (c) 2005-2012, Unit-API contributors, JScience and others
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package org.unitsofmeasurement.test.unit;

import org.unitsofmeasurement.quantity.Information;

/**
 * @author Werner Keil
 * @version 1.1 ($Revision$), $Date: 2012-04-30 01:07:51 +0200 (Mo, 30 Apr
 *          2012) $
 */
public class BitUnit extends BaseUnit<Information<Number>> {

	public static final BitUnit bit = new BitUnit("bit", 1.0); // reference
	// Unit
	public static final BitUnit REF_UNIT = bit; // reference Unit
	public static final BitUnit kb = new BitUnit("kb", 1.0e3);

	public BitUnit(String name2, double convF) {
		super(name2);
		name = name2;
		multFactor = convF;

	}

	@Override
	public BitUnit getSystemUnit() {
		return REF_UNIT;
	}

}
