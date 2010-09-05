/**
 *  The Units of Measure API, UCUM codes, UCUM table (regardless of format),
 *  and UCUM Specification are copyright © 1999-2010, Regenstrief Institute, Inc.
 *  and the Unified Codes for Units of Measures (UCUM) Organization.
 *  All rights reserved.
 *
 * See TermsOfUse for details.
 */
package org.unitsofmeasure;

import org.unitsofmeasure.quantity.Area;

/**
 * @author paul.morrison
 */
public class AreaUnit extends AbstractUnit<Area> {

    public static final AreaUnit sqmetre = new AreaUnit("sqmetre", 1.0); // reference
    // Unit
    public static final AreaUnit REF_UNIT = sqmetre; // reference Unit
    public static final AreaUnit sqmile = new AreaUnit("sqmile",
	    1609.0 * 1609.0);
    public static final AreaUnit acre = new AreaUnit("acre", 4047.0);
    public static final AreaUnit hectare = new AreaUnit("hectare", 1.0e4);

    public AreaUnit(String name2, double convF) {
	name = name2;
	multFactor = convF;

    }

    @Override
    public Unit<Area> toMetric() {
	return REF_UNIT;
    }

}
