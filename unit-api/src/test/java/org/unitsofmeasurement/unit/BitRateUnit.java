/**
 * Unit-API - Units of Measurement API for Java (http://unitsofmeasurement.org)
 * Copyright (c) 2005-2011, Unit-API contributors, JScience and others
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package org.unitsofmeasurement.unit;

import org.unitsofmeasurement.quantity.InformationRate;

/**
 * @author Werner Keil
 * @version 1.0 ($Revision$), $Date$
 */
public class BitRateUnit extends AbstractUnit<InformationRate> {

	public static final BitRateUnit bps = new BitRateUnit("bps", 1.0); // reference
    // Unit
	public static final BitRateUnit REF_UNIT = bps; // reference Unit
	public static final BitRateUnit kb = new BitRateUnit("kb", 1.0e3);

    public BitRateUnit(String name2, double convF) {
		name = name2;
		multFactor = convF;
    }

    @Override
	public Unit<InformationRate> getSystemUnit() {
		return REF_UNIT;
    }

}
