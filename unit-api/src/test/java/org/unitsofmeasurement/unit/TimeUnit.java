/**
 * Unit-API - Units of Measurement API for Java (http://unitsofmeasurement.org)
 * Copyright (c) 2005-2011, Unit-API contributors, JScience and others
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package org.unitsofmeasurement.unit;

import org.unitsofmeasurement.quantity.Time;

/**
 * @author Werner Keil
 * @version 1.0 ($Revision: 133 $), $Date: 2010-10-29 17:17:07 +0100 (Fr, 29 Okt
 *          2010) $
 */
public class TimeUnit extends AbstractUnit<Time> {

	public static final TimeUnit s = new TimeUnit("s", 1.0); // reference
	// Unit
	public static final TimeUnit REF_UNIT = s; // reference Unit
	public static final TimeUnit h = new TimeUnit("h", 60);

	public TimeUnit(String name2, double convF) {
		name = name2;
		multFactor = convF;

	}

	@Override
	public Unit<Time> getSystemUnit() {
		return REF_UNIT;
	}

}
