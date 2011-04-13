/**
 * Unit-API - Units of Measurement API for Java (http://unitsofmeasurement.org)
 * Copyright (c) 2005-2011, Unit-API contributors, JScience and others
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package org.unitsofmeasurement.unit;

import org.unitsofmeasurement.quantity.Information;

/**
 * @author Werner Keil
 * @version 1.0 ($Revision: 133 $), $Date: 2010-10-29 17:17:07 +0100 (Fr, 29 Okt
 *          2010) $
 */
public class BitUnit extends AbstractUnit<Information> {

    public static final BitUnit bit = new BitUnit("bit", 1.0); // reference
    // Unit
	public static final BitUnit REF_UNIT = bit; // reference Unit
	public static final BitUnit kb = new BitUnit("kb", 1.0e3);

    public BitUnit(String name2, double convF) {
    name = name2;
    multFactor = convF;

    }

    @Override
	public Unit<Information> getSystemUnit() {
    return REF_UNIT;
    }

}
