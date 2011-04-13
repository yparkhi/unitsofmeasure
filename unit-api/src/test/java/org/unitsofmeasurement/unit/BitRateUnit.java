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
 * @version 1.0 ($Revision: 133 $), $Date: 2010-10-29 17:17:07 +0100 (Fr, 29 Okt
 *          2010) $
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
