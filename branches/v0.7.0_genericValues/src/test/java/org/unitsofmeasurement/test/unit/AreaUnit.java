/**
 * Unit-API - Units of Measurement API for Java (http://unitsofmeasurement.org)
 * Copyright (c) 2005-2011, Unit-API contributors, JScience and others
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package org.unitsofmeasurement.test.unit;

import org.unitsofmeasurement.quantity.Area;

/**
 * @author paul.morrison
 */
public class AreaUnit extends BaseUnit<Area<Number>> {

	public static final AreaUnit sqmetre = new AreaUnit("sqmetre", 1.0); // reference
	// Unit
	public static final AreaUnit REF_UNIT = sqmetre; // reference Unit
	public static final AreaUnit sqmile = new AreaUnit("sqmile",
			1609.0 * 1609.0);
	public static final AreaUnit acre = new AreaUnit("acre", 4047.0);
	public static final AreaUnit hectare = new AreaUnit("hectare", 1.0e4);

	public AreaUnit(String symbol, String name2, double convF) {
		super(symbol);
		name = name2;
		multFactor = convF;
	}

	/**
	 * @deprecated should have a symbol
	 * @param name2
	 * @param convF
	 */
	public AreaUnit(String name2, double convF) {
		this("", name2, convF);
	}

	@Override
	public AreaUnit getSystemUnit() {
		return REF_UNIT;
	}
}
